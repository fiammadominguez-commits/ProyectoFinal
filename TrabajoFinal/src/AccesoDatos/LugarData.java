/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Lugar;
import Entidades.RutaViaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LugarData {

    private Connection con = null;
    private RutaViajeData rutaData = new RutaViajeData();

    public LugarData() {
        con = Conexion.getConexion();
    }

    public void guardarLugar(Lugar lugar) {

        String sql = "INSERT INTO lugares "
                + "(ID_Ruta, NumeroAsiento, Estado) "
                + "VALUES (?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, lugar.getRuta().getIdRuta());
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
    
    public void eliminarLugar(Lugar lugar){
    String sql = "DELETE FROM lugares WHERE ID_Lugar = ?";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, lugar.getIdLugar());
    ps.executeUpdate();
        System.out.println("Lugar eliminado con exito");
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al eliminar Lugar "+ ex.getMessage());
    }
    }
    
    public void darDeBajaLugar(Lugar lugar){
    String sql = "UPDATE lugares SET Estado = false WHERE ID_Lugar = ?";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, lugar.getIdLugar());
    ps.executeUpdate();
        System.out.println("Lugar dado de Baja con exito!");
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al dar de baja lugar "+ ex.getMessage());
    }
    }
    
     public void darDeAltaLugar(Lugar lugar){
    String sql = "UPDATE lugares SET Estado = true WHERE ID_Lugar = ?";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, lugar.getIdLugar());
    ps.executeUpdate();
        System.out.println("Lugar dado de Baja con exito!");
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al dar de baja lugar "+ ex.getMessage());
    }
    }
     
     public void modificarLugar(Lugar lugarNuevo){
     String sql = "UPDATE lugares SET ID_Ruta = ?, NumeroAsiento = ?, Estado = ? WHERE ID_Lugar = ?";
     
     try{
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, lugarNuevo.getRuta().getIdRuta());
     ps.setInt(2, lugarNuevo.getNumeroAsiento());
     ps.setBoolean(3, lugarNuevo.isEstado());
     ps.setInt(4, lugarNuevo.getIdLugar());
     ps.executeUpdate();
         System.out.println("Lugar modificado con exito");
     ps.close();
     }
     catch(SQLException ex){
         System.out.println("Error al modificar lugar");
     }
     }
     
//     public Lugar buscarLugarPorID(int id){
//     Lugar lugar = null;
//     RutaViaje ruta = null;
//     String sql = "SELECT * FROM lugares WHERE ID_Lugar = ?";
//     
//     try{
//     PreparedStatement ps = con.prepareStatement(sql);
//     ps.setInt(1, id);
//     ResultSet rs = ps.executeQuery();
//     
//         while (rs.next()) {
//             
//             ruta = rutaData.BuscarRutaPorID(rs.getInt("ID_Ruta"));
//             lugar = new Lugar(
//             rs.getInt("ID_Lugar"),
//                     ruta,
//                     rs.getInt("NumeroAsiento"),
//                     rs.getBoolean("Estado")
//             );
//         }
//     }
//     catch(SQLException ex){
//         System.out.println("Error al buscarLugar "+ex.getMessage());
//     }
//     
//     return lugar;
//     }
}