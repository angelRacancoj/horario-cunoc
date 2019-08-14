/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import algoritmo_horario.nodo;
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
public class docenteCursoDB {
    private Connection conexion;

    public docenteCursoDB(Connection conexion) {
        this.conexion = conexion;
    }
    
    public LinkedList<nodo> getNodosDocenteCurso() throws InputsVaciosException{
        try {
            PreparedStatement sentencia = conexion.prepareStatement(queries.DOCENTE_CURSO);
            return consultaDocenteCurso(sentencia);
        } catch (InputsVaciosException | SQLException e) {
            throw new InputsVaciosException("Error en la consulta de Docente Curso");
        }
    }
    
    private LinkedList<nodo> consultaDocenteCurso(PreparedStatement sentencia) throws InputsVaciosException{
        LinkedList<nodo> nodos = new LinkedList<>();
        nodos.clear();
        
        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int idNodo = resultado.getInt("id_p_d_c");
                int idCurso = resultado.getInt("CURSO_id");
                int idDocente = resultado.getInt("DOCENTE_id");
                System.out.println("Nodo:"+idNodo+",Curso:"+idCurso+",Docente:"+idDocente);
                nodos.add(new nodo(idNodo,idCurso, idDocente));
            }
            System.out.println("------------Consulta Docente Curso--------------");
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException(e.getMessage());
        }
        return nodos;
    }
}
