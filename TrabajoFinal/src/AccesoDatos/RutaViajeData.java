/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Entidades.RutaViaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import AccesoDatos.ColectivoData;
import Entidades.Colectivo;
/**
 *
 * @author LAURA TELLO
 */
public class RutaViajeData {
    
    private Connection con = null;
    private ColectivoData coleData = new ColectivoData();

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
    
//    public RutaViaje buscarRutaPorID(int id){
//    RutaViaje ruta = null;
//    Colectivo cole = null;
//    String sql = "SELECT * FROM rutas WHERE ID_Ruta = ?";
//    try{
//    PreparedStatement ps = con.prepareStatement(sql);
//    ps.setInt(1, id);
//    ResultSet rs= ps.executeQuery();
//    
//        while (rs.next()) {
//            cole=coleData.buscarColectivoPorID(rs.getInt("ID_Colectivo"));
//            ruta = new RutaViaje(
//            rs.getInt("ID_Ruta"),
//                    rs.getString("Origen"),
//                    rs.getString("Destino"),
//                    rs.getTime("HoraSalida").toLocalTime(),
//                    rs.getTime("HoraLlegada").toLocalTime(),
//                   cole,
//                    rs.getDouble("Precio"),
//                    rs.getBoolean("Estado")
//            );
//        }
//        rs.close();
//        ps.close();
//    }
//    catch(SQLException ex){
//        System.out.println("Error al buscar ruta "+ ex.getMessage());
//    }
//    return ruta;
//    }
    
    public void eliminarRuta(RutaViaje ruta){
    String sql = "DELETE FROM rutas WHERE ID_Ruta = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, ruta.getIdRuta());
    ps.executeUpdate();
        System.out.println("Ruta eliminada con exito");
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al eliminar ruta"+ ex.getMessage());
    }
    }
    
    public void darDeBajaRuta(RutaViaje ruta){
    String sql = "UPDATE rutas SET Estado = false WHERE ID_Ruta = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, ruta.getIdRuta());
    ps.executeUpdate();
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al dar de Baja la ruta "+ ex.getMessage()); 
    }
    }
    
    public void darDeAltaRuta(RutaViaje ruta){
    String sql = "UPDATE rutas SET Estado = true WHERE ID_Ruta = ?";
    try{
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, ruta.getIdRuta());
    ps.executeUpdate();
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("Error al dar de Alta la ruta "+ ex.getMessage()); 
    }
    }
    
    public void modificarRuta(RutaViaje rutaNueva){
    String sql = "UPDATE rutas SET Origen = ?, Destino = ?, HoraSalida = ?, HoraLlegada = ?, ID_Colectivo = ?, Precio = ?, Estado = ? WHERE ID_Ruta = ?";
    try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, rutaNueva.getOrigen());
            ps.setString(2, rutaNueva.getDestino());
            ps.setTime(3, java.sql.Time.valueOf(rutaNueva.getHoraSalida()));
            ps.setTime(4, java.sql.Time.valueOf(rutaNueva.getHoraLlegada()));
            ps.setInt(5, rutaNueva.getColectivo().getIdColectivo());
            ps.setDouble(6, rutaNueva.getPrecio());
            ps.setBoolean(7, rutaNueva.isEstado());
            ps.setInt(8, rutaNueva.getIdRuta());

            ps.executeUpdate();

            ps.close();

            System.out.println("Ruta Actualizada");

        } catch (SQLException ex) {

            System.out.println("Error al actualizar ruta");
            System.out.println(ex.getMessage());
        }
    }
}
