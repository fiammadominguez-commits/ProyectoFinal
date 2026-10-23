/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        System.out.println("Pasajero guardado con exito");

    } catch (SQLException ex) {

        System.out.println("Error al guardar pasajero");
    }
}
    
    public void eliminarPasajero(Pasajero p){
    String sql = "DELETE FROM pasajeros WHERE ID_Pasajero = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, p.getIdPasajero());
    ps.executeUpdate();
    ps.close();
        System.out.println("Passajero eliminado con exito");
    }
    catch(SQLException ex){
        System.out.println("Error al eliminar pasajero"+ ex.getMessage());
    }
    }
    
    public void darDeBajaPasajero(Pasajero p){
    String sql = "UPDATE pasajeros SET Estado = false WHERE ID_Pasajero = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, p.getIdPasajero());
    ps.executeUpdate();
    ps.close();
    System.out.println("Pasajero dado de baja con exito");
    }
    catch(SQLException ex){
        System.out.println("Error al dar de baja al pasajero"+ ex.getMessage());
    }
    }
    
    public void modificarPasajero(Pasajero p){
    String sql = "UPDATE pasajeros SET Nombre = ?, Apellido = ?, Correo = ?, Telefono = ?, Estado = ? WHERE ID_Pasajero = ?";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, p.getNombre());
    ps.setString(2, p.getApellido());
    ps.setString(3, p.getCorreo());
    ps.setString(4, p.getTelefono());
    ps.setBoolean(5, p.isEstado());
    ps.executeUpdate();
        System.out.println("Pasajero modificado con exito");
    
    }
    catch(SQLException ex){
        System.out.println("Error al modificarPasajero");
    }
    }
    
    public Pasajero buscarPasajeroPorDNI(String dni){
    Pasajero p = null;
    String sql = "SELECT * FROM pasajeros WHERE DNI = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, dni);
    ResultSet rs = ps.executeQuery();
    
        if (rs.next()) {
            p = new Pasajero(
                    rs.getInt("ID_Pasajero"),
                    rs.getString("DNI"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Correo"),
                    rs.getString("Telefono"),
                    rs.getBoolean("Estado")
            );
        }
    rs.close();
    ps.close();
    
    }
    catch(SQLException ex){
        System.out.println("Error al buscar pasajero"+ ex.getMessage());
    }
    return p;
    }
    
}

