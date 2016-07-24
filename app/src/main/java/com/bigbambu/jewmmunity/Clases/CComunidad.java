package com.bigbambu.jewmmunity.Clases;

import android.util.Range;

import com.bigbambu.jewmmunity.Utiles.Constants;

import java.util.List;
/**
 * Created by Joel on 24-Jul-16.
 */

public class CComunidad {
    private String nombre;
    private String direccion;
    private int telefono;
    private boolean alojamiento;
    private int cantidad_miembros;
    private List<CUsuario> administradores;
    private List<CEvento> eventos;
    private List<CViaje> viajes;
    private Range edades;
    private Constants.TipoComunidad tipo;
    private Constants.Asendencia asendencia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public int getCantidad_miembros() {
        return cantidad_miembros;
    }

    public void setCantidad_miembros(int cantidad_miembros) {
        this.cantidad_miembros = cantidad_miembros;
    }

    public List<CUsuario> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<CUsuario> administradores) {
        this.administradores = administradores;
    }

    public List<CEvento> getEventos() {
        return eventos;
    }

    public void setEventos(List<CEvento> eventos) {
        this.eventos = eventos;
    }

    public List<CViaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<CViaje> viajes) {
        this.viajes = viajes;
    }

    public Range getEdades() {
        return edades;
    }

    public void setEdades(Range edades) {
        this.edades = edades;
    }

    public Constants.TipoComunidad getTipo() {
        return tipo;
    }

    public void setTipo(Constants.TipoComunidad tipo) {
        this.tipo = tipo;
    }

    public Constants.Asendencia getAsendencia() {
        return asendencia;
    }

    public void setAsendencia(Constants.Asendencia asendencia) {
        this.asendencia = asendencia;
    }
}
