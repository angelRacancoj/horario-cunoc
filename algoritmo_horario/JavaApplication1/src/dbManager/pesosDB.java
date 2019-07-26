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

    public pesosDB(Connection conexion) {
        this.conexion = conexion;
        this.cons = new constants(conexion);
    }

    public LinkedList<nodo> getPesos(LinkedList<nodo> nodos) throws InputsVaciosException {
        try {
            for (int i = 0; i < nodos.size(); i++) {
                PreparedStatement sentencia = conexion.prepareStatement(queries.PESOS);
                sentencia.setString(1, String.valueOf(nodos.get(i).getIdCurso()));

                LinkedList<peso> pesos = new LinkedList<>();

                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    String id = resultado.getString("ID");
                    String peso = resultado.getString("peso");
                    pesos.add(new peso(String.valueOf(nodos.get(i).getIdCurso()), id, peso, feromona()));
                }
                nodos.get(i).setPesos(pesos);
                resultado.close();
                sentencia.close();
            }
            System.out.println("---------------Pesos Agregados---------------");

        } catch (Exception e) {
            throw new InputsVaciosException("Error en la consulta de los Pesos");
        }
        return nodos;
    }

    private double feromona() {
        return (Math.random() * ((0.5 - 0.1) + 1)) + 0.1;
    }
}
