/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Lugar {

    private int idLugar;
    private RutaViaje ruta;
    private int numeroAsiento;
    private boolean estado;

    public Lugar() {
    }

    public Lugar(RutaViaje ruta, int numeroAsiento, boolean estado) {
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public Lugar(int idLugar, RutaViaje ruta, int numeroAsiento, boolean estado) {
        this.idLugar = idLugar;
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public void setRuta(RutaViaje ruta) {
        this.ruta = ruta;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}