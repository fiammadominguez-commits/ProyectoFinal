/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Lugar;
import Entidades.Pasaje;
import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PasajeData {

    private LugarData lugarData = new LugarData();
    private PasajeroData pasajeroData = new PasajeroData();
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
    
    public void actualizarPasaje(Pasaje pasaje){
    String sql = "UPDATE pasajes SET ID_Pasajero = ?, ID_Lugar = ?, FechaVenta = ?, HoraVenta = ?, Precio = ?, Estado = ? WHERE ID_Pasaje = ?";
    try{
    PreparedStatement ps= con.prepareStatement(sql);
    ps.setInt(1, pasaje.getPasajero().getIdPasajero());
    ps.setInt(2, pasaje.getLugar().getIdLugar());
    ps.setObject(3, pasaje.getFechaVenta());
    ps.setObject(4, pasaje.getHoraVenta());
    ps.setDouble(5, pasaje.getPrecio());
    ps.setBoolean(6, pasaje.isEstado());
    ps.setInt(7, pasaje.getIdPasaje());
    ps.executeUpdate();
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al Actualizar pasaje"+ ex.getMessage());
    }
    }
    
    public void eliminarPasaje(Pasaje pasaje){
    String sql= "DELETE FROM pasajes WHERE ID_Pasaje = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, pasaje.getIdPasaje());
    }
    catch(SQLException ex){
        System.out.println("Error al eliminar pasaje" + ex.getMessage());
    }
    }
    
    public Pasaje BuscarPasaje(int id){
    Pasaje pasaje=null;
    Lugar lugar = null;
    Pasajero pasajero = null;
    
    String sql = "SELECT * FROM pasajes WHERE ID_Pasaje = ?";
    try{
    PreparedStatement ps= con.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lugar = lugarData.buscarLugarPorID(rs.getInt("ID_Lugar"));
            pasajero = pasajeroData.buscarPasajeroPorID(rs.getInt("ID_Pasajero"));
            
            pasaje = new Pasaje(
            rs.getInt("ID_Pasaje"),
        pasajero,
        lugar,
        rs.getObject("FechaVenta", LocalDate.class),
        rs.getObject("HoraVenta", LocalTime.class),
        rs.getDouble("Precio"),
        rs.getBoolean("Estado")
        );
        
        }
    }
    catch(SQLException ex){
        System.out.println("Eror al Buscar pasaje"+ ex.getMessage());
    }
    return pasaje;
    }
    
     public Pasaje BuscarPasajePorPasajeroLugar(Pasajero p, Lugar l){
    Pasaje pasaje=null;
    Lugar lugar = null;
    Pasajero pasajero = null;
    
    String sql = "SELECT * FROM pasajes WHERE ID_Pasajero = ? AND ID_Lugar = ?";
    try{
    PreparedStatement ps= con.prepareStatement(sql);
    ps.setInt(1, p.getIdPasajero());
    ps.setInt(2, l.getIdLugar());
    ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lugar = lugarData.buscarLugarPorID(rs.getInt("ID_Lugar"));
            pasajero = pasajeroData.buscarPasajeroPorID(rs.getInt("ID_Pasajero"));
            
            pasaje = new Pasaje(
            rs.getInt("ID_Pasaje"),
        pasajero,
        lugar,
        rs.getObject("FechaVenta", LocalDate.class),
        rs.getObject("HoraVenta", LocalTime.class),
        rs.getDouble("Precio"),
        rs.getBoolean("Estado")
        );
        
        }
    }
    catch(SQLException ex){
        System.out.println("Eror al Buscar pasaje"+ ex.getMessage());
    }
    return pasaje;
    }
}