/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Pasaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasajeData {

    private Connection con = null;

    public PasajeData() {
        con = Conexion.getConexion();
    }

    public void guardarPasaje(Pasaje pasaje) {

        String sql = "INSERT INTO pasajes "
                + "(ID_Pasajero, ID_Lugar, FechaVenta, "
                + "HoraVenta, Precio, Estado) "
                + "VALUES (?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getLugar().getIdLugar());

            ps.setDate(3,
                    java.sql.Date.valueOf(
                            pasaje.getFechaVenta()));

            ps.setTime(4,
                    java.sql.Time.valueOf(
                            pasaje.getHoraVenta()));

            ps.setDouble(5, pasaje.getPrecio());
            ps.setBoolean(6, pasaje.isEstado());

            ps.executeUpdate();

            ps.close();

            System.out.println("Pasaje guardado");

        } catch (SQLException ex) {

            System.out.println("Error al guardar pasaje");
            System.out.println(ex.getMessage());
        }
    }
}