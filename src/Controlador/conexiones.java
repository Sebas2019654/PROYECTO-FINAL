/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class conexiones {

    String url = "jdbc:postgresql://localhost:5432/Estacionamiento";
    String pass = "18032001";
    String user = "postgres";

    public Connection Conectarse() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, pass);

            System.out.println("conectado con exito");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return conexion;

    }

}
