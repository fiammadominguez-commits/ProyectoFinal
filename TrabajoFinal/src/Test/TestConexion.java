/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import AccesoDatos.Conexion;
import AccesoDatos.PasajeroData;
import Entidades.Pasajero;
/**
 *
 * @author LAURA TELLO
 */
public class TestConexion {
    
        public static void main(String[] args) {

      Conexion.getConexion();
 

        Pasajero pasajero = new Pasajero();

        pasajero.setDni("40111222");
        pasajero.setNombre("Laura");
        pasajero.setApellido("Tello");
        pasajero.setCorreo("laura@gmail.com");
        pasajero.setTelefono("2664000000");
        pasajero.setEstado(true);

        PasajeroData pd = new PasajeroData();

        pd.guardarPasajero(pasajero);
    }
    }
        

