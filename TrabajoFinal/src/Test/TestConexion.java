/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import AccesoDatos.ColectivoData;
import AccesoDatos.LugarData;
import AccesoDatos.PasajeData;
import AccesoDatos.PasajeroData;
import AccesoDatos.RutaViajeData;

import Entidades.Colectivo;
import Entidades.Lugar;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.RutaViaje;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestConexion {

    public static void main(String[] args) {

        // PASAJERO

        Pasajero pasajero = new Pasajero();

        pasajero.setDni("59340366");
        pasajero.setNombre("Ana");
        pasajero.setApellido("Sosa");
        pasajero.setCorreo("ana@gmail.com");
        pasajero.setTelefono("2664888100");
        pasajero.setEstado(true);

        PasajeroData pd = new PasajeroData();
        pd.guardarPasajero(pasajero);

        // COLECTIVO

        Colectivo colectivo = new Colectivo();

        colectivo.setMatricula("AF123JK");
        colectivo.setMarca("Mercedes");
        colectivo.setModelo("O500");
        colectivo.setCapacidad(50);
        colectivo.setChofer("Pedro Ortiz");
        colectivo.setEstado(true);

        ColectivoData cd = new ColectivoData();
        cd.guardarColectivo(colectivo);

        // OBJETOS CON IDs EXISTENTES

        Colectivo colectivoFK = new Colectivo();
        colectivoFK.setIdColectivo(1);

        Pasajero pasajeroFK = new Pasajero();
        pasajeroFK.setIdPasajero(1);

        // RUTA

        RutaViaje ruta = new RutaViaje();

        ruta.setOrigen("San Luis");
        ruta.setDestino("La Rioja");
        ruta.setHoraSalida(LocalTime.of(8, 0));
        ruta.setHoraLlegada(LocalTime.of(12, 30));
        ruta.setColectivo(colectivoFK);
        ruta.setPrecio(15000);
        ruta.setEstado(true);

        RutaViajeData rd = new RutaViajeData();
        rd.guardarRuta(ruta);

        // OBJETO RUTA EXISTENTE

        RutaViaje rutaFK = new RutaViaje();
        rutaFK.setIdRuta(1);

        // LUGAR

        Lugar lugar = new Lugar();

        lugar.setRuta(rutaFK);
        lugar.setNumeroAsiento(1);
        lugar.setEstado(true);

        LugarData ld = new LugarData();
        ld.guardarLugar(lugar);

        // LUGAR EXISTENTE

Lugar lugarFK = new Lugar();
lugarFK.setIdLugar(2);

// PASAJE

Pasaje pasaje = new Pasaje();

pasaje.setPasajero(pasajeroFK);
pasaje.setLugar(lugarFK);
pasaje.setFechaVenta(LocalDate.now());
pasaje.setHoraVenta(LocalTime.now());
pasaje.setPrecio(15000);
pasaje.setEstado(true);

PasajeData pasajeData = new PasajeData();
pasajeData.guardarPasaje(pasaje);

        
    }
}
        

