/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author LAURA TELLO
 */
public class Pasaje {
        private int idPasaje;
    private Pasajero pasajero;
    private Lugar lugar;
    private RutaViaje rutaViaje;
    private LocalDate fechaVenta;
    private LocalTime horaVenta;
    private double precio;
    private boolean estado;

    public Pasaje() {
    }

    public Pasaje(Pasajero pasajero, Lugar lugar,
            RutaViaje rutaViaje, LocalDate fechaVenta,
            LocalTime horaVenta, double precio,
            boolean estado) {

        this.pasajero = pasajero;
        this.lugar = lugar;
        this.rutaViaje = rutaViaje;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precio = precio;
        this.estado = estado;
    }

    public Pasaje(int idPasaje, Pasajero pasajero,
            Lugar lugar, RutaViaje rutaViaje,
            LocalDate fechaVenta, LocalTime horaVenta,
            double precio, boolean estado) {

        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.lugar = lugar;
        this.rutaViaje = rutaViaje;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public RutaViaje getRutaViaje() {
        return rutaViaje;
    }

    public void setRutaViaje(RutaViaje rutaViaje) {
        this.rutaViaje = rutaViaje;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalTime getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaVenta) {
        this.horaVenta = horaVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
