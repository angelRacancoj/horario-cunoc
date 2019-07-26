/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import algoritmo_horario.curso;
import excepciones.InputsVaciosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author angelrg
 */
public class cursoDB {

    private Connection conexion;

    public cursoDB(Connection conexion) {
        this.conexion = conexion;
    }

    public LinkedList<curso> getCursos() throws InputsVaciosException {
        try {
            PreparedStatement sentencia = conexion.prepareStatement(queries.curso_dias);
            return consultaCliente(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la consulta de los Cursos");
        }
    }

    private LinkedList<curso> consultaCliente(PreparedStatement sentencia) throws InputsVaciosException {
        LinkedList<curso> cursos = new LinkedList<>();
        cursos.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String id = resultado.getString("ID");
                String nombre = resultado.getString("nombre");
                String lunes = resultado.getString("lunes");
                String martes = resultado.getString("martes");
                String miercoles = resultado.getString("miercoles");
                String jueves = resultado.getString("jueves");
                String viernes = resultado.getString("viernes");
                String alumnos = resultado.getString("alumnos");
                cursos.add(new curso(id, nombre, lunes, martes, miercoles, jueves, viernes, alumnos));
            }
            System.out.println("-----------Consulta Curso-------------");
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException(e.getMessage());
        }
        return cursos;
    }
}
