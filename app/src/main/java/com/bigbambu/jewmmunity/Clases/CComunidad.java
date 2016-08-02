package com.bigbambu.jewmmunity.Clases;

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
    private int antiguedad;
    private List<CUsuario> administradores;
    private List<CUsuario> miembros;
    private List<CEvento> eventos;
    private List<CViaje> viajes;
    private int min_edad;
    private int max_edad;
    private Constants.TipoComunidad tipo;
    private Constants.Asendencia asendencia;

    public static CComunidad generarComunidad()
    {
        CComunidad retornar = new CComunidad();
        retornar.setNombre("unaComunidad");
        retornar.setDireccion("calle falsa 123");
        retornar.setTelefono(12345678);
        retornar.setAlojamiento(true);
        retornar.setMinEdad(18);
        retornar.setMaxEdad(25);
        retornar.setTipo(Constants.TipoComunidad.REFORMISTA);
        retornar.setAsendencia(Constants.Asendencia.ASHKENAZI);

        return retornar;
    }

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

    public boolean getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(boolean alojamiento) {
        this.alojamiento = alojamiento;
    }

    public List<CUsuario> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<CUsuario> administradores) {
        this.administradores = administradores;
    }

    public List<CUsuario> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<CUsuario> miembros) {
        this.miembros = administradores;
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

    public int getMinEdad() {
        return min_edad;
    }

    public void setMinEdad(int min_edad) {
        this.min_edad = min_edad;
    }

    public int getMaxEdad() {
        return max_edad;
    }

    public void setMaxEdad(int max_edad) {
        this.max_edad = max_edad;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
