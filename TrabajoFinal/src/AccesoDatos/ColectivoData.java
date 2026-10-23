/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Colectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author LAURA TELLO
 */
public class ColectivoData {
    
    private Connection con = null;

    public ColectivoData() {
        con = Conexion.getConexion();
    }

    public void guardarColectivo(Colectivo colectivo){

        String sql = "INSERT INTO colectivos "
                + "(Matricula, Marca, Modelo, Capacidad, Chofer, Estado) "
                + "VALUES (?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setString(5, colectivo.getChofer());
            ps.setBoolean(6, colectivo.isEstado());

            ps.executeUpdate();

            ps.close();

            System.out.println("Colectivo guardado");

        } catch (SQLException ex) {

            System.out.println("Error al guardar colectivo");
        }
    }
}
