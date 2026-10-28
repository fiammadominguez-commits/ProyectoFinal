/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Colectivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public void eliminarColectivo(Colectivo colectivo) {

        String sql = "DELETE FROM colectivos WHERE ID_Colectivo = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, colectivo.getIdColectivo());

            ps.executeUpdate();

            ps.close();

            System.out.println("Colectivo eliminado con exito");

        } catch (SQLException ex) {

            System.out.println("Error al eliminar colectivo: " + ex.getMessage());
        }
    }

    public void darDeBajaColectivo(Colectivo colectivo) {

        String sql = "UPDATE colectivos SET Estado = false WHERE ID_Colectivo = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, colectivo.getIdColectivo());

            ps.executeUpdate();

            ps.close();

            System.out.println("Colectivo dado de baja con exito");

        } catch (SQLException ex) {

            System.out.println("Error al dar de baja el colectivo: " + ex.getMessage());
        }
    }

   
    public void modificarColectivo(Colectivo colectivo) {

        String sql = "UPDATE colectivos SET Matricula = ?, Marca = ?, Modelo = ?, "
                + "Capacidad = ?, Chofer = ?, Estado = ? "
                + "WHERE ID_Colectivo = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setString(5, colectivo.getChofer());
            ps.setBoolean(6, colectivo.isEstado());
            ps.setInt(7, colectivo.getIdColectivo());

            ps.executeUpdate();

            ps.close();

            System.out.println("Colectivo modificado con exito");

        } catch (SQLException ex) {

            System.out.println("Error al modificar colectivo: " + ex.getMessage());
        }
    }

    
    public Colectivo buscarColectivoPorMatricula(String matricula) {

        Colectivo colectivo = null;

        String sql = "SELECT * FROM colectivos WHERE Matricula = ?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, matricula);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                colectivo = new Colectivo(
                        rs.getInt("ID_Colectivo"),
                        rs.getString("Matricula"),
                        rs.getString("Marca"),
                        rs.getString("Modelo"),
                        rs.getInt("Capacidad"),
                        rs.getString("Chofer"),
                        rs.getBoolean("Estado")
                );
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {

            System.out.println("Error al buscar colectivo: " + ex.getMessage());
        }

        return colectivo;
    }
}
