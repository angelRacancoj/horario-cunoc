/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import algoritmo_horario.constants;
import algoritmo_horario.nodo;
import algoritmo_horario.peso;
import excepciones.InputsVaciosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author angelrg
 */
public class pesosDB {

    private Connection conexion;
    private constants cons;

    public pesosDB(Connection conexion, constants cons) {
        this.conexion = conexion;
        this.cons = cons;
    }

    public void getPesos(LinkedList<nodo> nodos, int semestre) throws InputsVaciosException {
        try {
            for (int i = 0; i < nodos.size(); i++) {
                int semestreCorrecto = 0;
                int esObligatorio = 0;
                int carreraCorrecto = 0;
                int mismoSemestre = 0;
                double proporcionAlumnos = 0;
                LinkedList<peso> pesos = new LinkedList<>();
                nodo nodoActual = nodos.get(i);

                for (int j = 0; j < nodos.size(); j++) {
                    nodo nodoSecundario = nodos.get(j);
                    if (nodoActual != nodoSecundario) {
                        PreparedStatement sentencia = conexion.prepareStatement(queries.MISMO_SEMESTRE);
                        sentencia.setString(1, String.valueOf(nodoSecundario.getIdCurso()));
                        sentencia.setString(2, String.valueOf(nodoActual.getIdCurso()));

                        ResultSet resultado = sentencia.executeQuery();
                        while (resultado.next()) {
                            int aux = resultado.getInt("COUNT(*)");
                            if (aux > 0) {
                                mismoSemestre = 1;
                            } else {
                                mismoSemestre = 0;
                            }
                        }
                        resultado.close();
                        sentencia.close();

                        //Obtenemos la cantidad de elementos que son diferente semestre en base a los cursos
                        PreparedStatement sentencia2 = conexion.prepareStatement(queries.DIFERENTE_CARRERA);
                        sentencia2.setString(1, String.valueOf(nodoSecundario.getIdCurso()));
                        sentencia2.setString(2, String.valueOf(nodoActual.getIdCurso()));

                        int aux2 = 0;
                        ResultSet resultado2 = sentencia2.executeQuery();
                        while (resultado2.next()) {
                            aux2 = resultado2.getInt("COUNT(*)");
                        }
                        resultado2.close();
                        sentencia2.close();

                        //Obtenemos la cantidad de relaciones que existe entre dos cursos
                        PreparedStatement sentencia3 = conexion.prepareStatement(queries.INTERSECCION_ENTRE_CURSOS);
                        sentencia3.setString(1, String.valueOf(nodoSecundario.getIdCurso()));
                        sentencia3.setString(2, String.valueOf(nodoActual.getIdCurso()));

                        int aux3 = 0;
                        ResultSet resultado3 = sentencia3.executeQuery();
                        while (resultado3.next()) {
                            aux3 = resultado3.getInt("COUNT(*)");
                        }
                        resultado3.close();
                        sentencia3.close();

                        //Calculamos la diferencia entre las dos consultas anteriores (aux2 u aux3)
                        //Para verificar si los dos cursos evaluados en algun punto son del la misma carrera
                        if ((aux3 > 0) && (aux3 > aux2)) {
                            carreraCorrecto = 1;
                        } else {
                            carreraCorrecto = 0;
                        }

                        //Esta query esta dedicada a ver si ambos cursos son obligatorio
                        PreparedStatement sentencia4 = conexion.prepareStatement(queries.SON_OBLIGATORIOS);
                        sentencia4.setString(1, String.valueOf(nodoSecundario.getIdCurso()));
                        sentencia4.setString(2, String.valueOf(nodoActual.getIdCurso()));
                        sentencia4.setString(3, String.valueOf(constants.CURSO_OBLIGATORIO));

                        ResultSet resultado4 = sentencia4.executeQuery();
                        while (resultado4.next()) {
                            int aux = resultado4.getInt("COUNT(*)");
                            if (aux > 0) {
                                esObligatorio = 1;
                            } else {
                                esObligatorio = 0;
                            }
                        }
                        resultado4.close();
                        sentencia4.close();

                        //Se verifica que sea del semestre correcto, el nodo al que se movera
                        if (semestre == constants.PRIMER_SEMESTRE) {
                            PreparedStatement sentencia5 = conexion.prepareStatement(queries.PRIMER_SEMESTRE);
                            sentencia5.setString(1, String.valueOf(nodoSecundario.getIdCurso()));

                            ResultSet resultado5 = sentencia4.executeQuery();
                            while (resultado5.next()) {
                                int aux = resultado5.getInt("COUNT(*)");
                                if (aux > 0) {
                                    semestreCorrecto = 1;
                                } else {
                                    semestreCorrecto = 0;
                                }
                            }
                            resultado5.close();
                            sentencia5.close();
                        } else {
                            PreparedStatement sentencia5 = conexion.prepareStatement(queries.SEGUNDO_SEMESTRE);
                            sentencia5.setString(1, String.valueOf(nodoSecundario.getIdCurso()));

                            ResultSet resultado5 = sentencia4.executeQuery();
                            while (resultado5.next()) {
                                int aux = resultado5.getInt("COUNT(*)");
                                if (aux > 0) {
                                    semestreCorrecto = 1;
                                } else {
                                    semestreCorrecto = 0;
                                }
                            }
                            resultado5.close();
                            sentencia5.close();
                        }

                        //Se obtiene una proporcion de alumno del Curso al que se conectara.
                        PreparedStatement sentencia6 = conexion.prepareStatement(queries.SON_OBLIGATORIOS);
                        sentencia6.setString(1, String.valueOf(nodoSecundario.getIdCurso()));
                        sentencia6.setString(2, String.valueOf(nodoActual.getIdCurso()));
                        sentencia6.setString(3, String.valueOf(constants.CURSO_OBLIGATORIO));

                        ResultSet resultado6 = sentencia6.executeQuery();
                        while (resultado6.next()) {
                            proporcionAlumnos = resultado6.getDouble("Alumnos");
                        }
                        resultado6.close();
                        sentencia6.close();

//                        pesos.add(new peso(nodoSecundario, (semestreCorrecto + esObligatorio + carreraCorrecto + mismoSemestre + proporcionAlumnos), cons.getFeromonas()));
                        pesos.add(new peso(nodoSecundario, (semestreCorrecto + esObligatorio + carreraCorrecto + mismoSemestre + proporcionAlumnos), feromona()));
                    } else {
                        System.out.println("Es el mismo nodo, no se creara redundancia");
                    }
                }

                nodoActual.setPesos(pesos);
            }
            System.out.println("---------------Pesos Agregados---------------");

        } catch (Exception e) {
            throw new InputsVaciosException("Error en la consulta de los Pesos");
        }
    }

    private double feromona() {
        return (Math.random() * ((0.5 - 0.1) + 1)) + 0.1;
    }
}
