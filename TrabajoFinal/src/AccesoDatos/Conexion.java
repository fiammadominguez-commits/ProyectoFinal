/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LAURA TELLO
 */
public class Conexion {
    
    private static Connection conexion = null;

    private static final String URL =
            "jdbc:mariadb://localhost:3306/flecha_flash";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConexion() {

        try {

            if (conexion == null || conexion.isClosed()) {

                conexion = DriverManager.getConnection(
                        URL, USER, PASSWORD);

                System.out.println("Conexion exitosa");
            }

        } catch (SQLException ex) {

            System.out.println("Error: " + ex.getMessage());
        }

        return conexion;
    }
}
