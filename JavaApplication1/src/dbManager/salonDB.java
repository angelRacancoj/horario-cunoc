/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import algoritmo_horario.salon;
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
public class salonDB {

    private Connection conexion;

    public salonDB(Connection conexion) {
        this.conexion = conexion;
    }
    
    public LinkedList<salon> getSalones() throws InputsVaciosException{
        try {
            PreparedStatement sentencia = conexion.prepareStatement(queries.salones);
            return consultaSalon(sentencia);
        } catch (Exception e) {
            throw new InputsVaciosException(e.getMessage());        
        }
    }

    private LinkedList<salon> consultaSalon(PreparedStatement sentencia) throws InputsVaciosException {
        LinkedList<salon> salones = new LinkedList<>();
        salones.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String id = resultado.getString("ID");
                String nombre = resultado.getString("nombre");
                String capacidad = resultado.getString("capacidad");
                salones.add(new salon(id, nombre, capacidad));
            }
            System.out.println("--------------Consulta Salon----------------");
        } catch (SQLException e) {
            throw new InputsVaciosException(e.getMessage());
        }
        return salones;
    }
}
