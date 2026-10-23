/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Lugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author LAURA TELLO
 */
public class LugarData {
    
    private Connection con = null;

    public LugarData() {
        con = Conexion.getConexion();
    }

    public void guardarLugar(Lugar lugar) {

        String sql = "INSERT INTO lugares "
                + "(ID_Colectivo, NumeroAsiento, Estado) "
                + "VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, lugar.getColectivo().getIdColectivo());
            ps.setInt(2, lugar.getNumeroAsiento());
            ps.setBoolean(3, lugar.isEstado());

            ps.executeUpdate();

            ps.close();

            System.out.println("Lugar guardado");

        } catch (SQLException ex) {

            System.out.println("Error al guardar lugar");
            System.out.println(ex.getMessage());
        }
    }
}
