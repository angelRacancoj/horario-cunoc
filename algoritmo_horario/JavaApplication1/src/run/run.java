/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author angelrg
 */
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost?user=root&password=ex=d/dx=ex");
            System.out.println("conectado:" + connection.getCatalog());
            Statement seleccionarDB = connection.createStatement();
            seleccionarDB.executeUpdate("USE horario_db");
        } catch (Exception e) {
        }
    }
    
}
