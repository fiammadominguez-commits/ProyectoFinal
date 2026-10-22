/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author LAURA TELLO
 */
public class PasajeroData {
        private Connection con = null;

    public PasajeroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarPasajero(Pasajero pasajero) {

    String sql = "INSERT INTO pasajeros "+ "(DNI, Nombre, Apellido, Correo, Telefono, Estado) "
            + "VALUES (?,?,?,?,?,?)";

    try {

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, pasajero.getDni());
        ps.setString(2, pasajero.getNombre());
        ps.setString(3, pasajero.getApellido());
        ps.setString(4, pasajero.getCorreo());
        ps.setString(5, pasajero.getTelefono());
        ps.setBoolean(6, pasajero.isEstado());

        ps.executeUpdate();

        ps.close();

        System.out.println("Pasajero guardado");

    } catch (SQLException ex) {

        System.out.println("Error al guardar pasajero");
    }
}
    
}

