/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.RutaViaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author LAURA TELLO
 */
public class RutaViajeData {
    
    private Connection con = null;

    public RutaViajeData() {
        con = Conexion.getConexion();
    }

    public void guardarRuta(RutaViaje ruta) {

        String sql = "INSERT INTO rutas "
                + "(Origen, Destino, HoraSalida, HoraLlegada, "
                + "ID_Colectivo, Precio, Estado) "
                + "VALUES (?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, java.sql.Time.valueOf(ruta.getHoraSalida()));
            ps.setTime(4, java.sql.Time.valueOf(ruta.getHoraLlegada()));
            ps.setInt(5, ruta.getColectivo().getIdColectivo());
            ps.setDouble(6, ruta.getPrecio());
            ps.setBoolean(7, ruta.isEstado());

            ps.executeUpdate();

            ps.close();

            System.out.println("Ruta guardada");

        } catch (SQLException ex) {

            System.out.println("Error al guardar ruta");
            System.out.println(ex.getMessage());
        }
    }
}
