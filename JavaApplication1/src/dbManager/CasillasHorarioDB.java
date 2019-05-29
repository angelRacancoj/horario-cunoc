/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import algoritmo_horario.casillaHorario;
import excepciones.InputsVaciosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.joda.time.LocalTime;

/**
 *
 * @author angelrg
 */
public class CasillasHorarioDB {

    private Connection conexion;

    public CasillasHorarioDB(Connection conexion) {
        this.conexion = conexion;
    }

    public LinkedList<LinkedList<casillaHorario>> getCasillasHorario(int minPeriodo) throws SQLException {
        LinkedList<LinkedList<casillaHorario>> casillasHorario = new LinkedList<>();
        try {
            LinkedList<casillaHorario> horario = getHorarios();

            for (casillaHorario hor : horario) {
                LinkedList<casillaHorario> CasillaH = existeCasillasClase(casillasHorario, hor.getIdSalon());
                if (CasillaH != null) {
                    for (LocalTime i = hor.getInitHour(); i.isBefore(hor.getEndHour().minusMinutes(minPeriodo)); i.plusMinutes(minPeriodo)) {
                        CasillaH.add(new casillaHorario(hor.getIdSalon(), i, i.plusMinutes(minPeriodo)));
                    }
                } else {
                    LinkedList<casillaHorario> casillas = new LinkedList<>();
                    for (LocalTime i = hor.getInitHour(); i.isBefore(hor.getEndHour().minusMinutes(minPeriodo)); i.plusMinutes(minPeriodo)) {
                        horario.add(new casillaHorario(hor.getIdSalon(), i, i.plusMinutes(minPeriodo)));
                    }
                    casillasHorario.add(casillas);
                }
            }
            System.out.println("-------Crear Casillas/salon---------");
        } catch (InputsVaciosException e) {
            System.out.println("Error: " + e);
        }
        return casillasHorario;
    }

    private LinkedList<casillaHorario> getHorarios() throws SQLException, InputsVaciosException {
        LinkedList<casillaHorario> horario = new LinkedList<>();
        try {
            PreparedStatement sentencia = conexion.prepareStatement(queries.HORARIO_SALON);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String id = resultado.getString("ID");
                String inicio = resultado.getString("inicio");
                String fin = resultado.getString("fin");
                horario.add(new casillaHorario(id, inicio, fin));
            }
            System.out.println("------------Consulta Horario Salon---------------");
            resultado.close();
            sentencia.close();
        } catch (SQLException e) {
            throw new InputsVaciosException(e.getMessage());
        }
        return horario;
    }

    private LinkedList<casillaHorario> existeCasillasClase(LinkedList<LinkedList<casillaHorario>> casillasHorario, int id) {
        if (casillasHorario.size() > 0) {
            for (LinkedList<casillaHorario> casillas : casillasHorario) {
                if (casillas.get(1).getIdSalon() == id) {
                    return casillas;
                }
            }
            return null;
        } else {
            return null;
        }
    }

}
