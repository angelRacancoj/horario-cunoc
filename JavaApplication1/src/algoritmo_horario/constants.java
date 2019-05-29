/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo_horario;

import dbManager.queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author angelrg
 */
public class constants {
    
    private Connection conexion;
    
    public int duracionPeriodo;
    public int feromonas;
    public int hormigas;
    public int iteraciones;
    public float alpha;
    public float beta;
    
    public static int LUNES = 0;
    public static int MARTES = 1;
    public static int MIERCOLES = 2;
    public static int JUEVES = 3;
    public static int VIERNES = 4;

    public constants(Connection conexion) {
        this.conexion = conexion;
        cargarConstantes();
    }
    
    

    private void cargarConstantes(){
        try {
            PreparedStatement sentencia = conexion.prepareStatement(queries.CONSTANTES);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {                
                duracionPeriodo = resultado.getInt("min");
                feromonas = resultado.getInt("feromonas");
                hormigas = resultado.getInt("hormigas");
                iteraciones = resultado.getInt("iteraciones");
                alpha = Float.valueOf(resultado.getString("alpha"));
                beta = Float.valueOf(resultado.getString("beta"));
            }
            System.out.println("--------Consulta Variables----------");
            resultado.close();
            sentencia.close();
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error:\n");
            e.getStackTrace();
        }
    }

    public int getDuracionPeriodo() {
        return duracionPeriodo;
    }

    public int getFeromonas() {
        return feromonas;
    }

    public int getHormigas() {
        return hormigas;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public float getAlpha() {
        return alpha;
    }

    public float getBeta() {
        return beta;
    }
}
