package com.bigbambu.jewmmunity.Clases;

import com.bigbambu.jewmmunity.Utiles.Constants;
import com.google.android.gms.maps.model.LatLng;

import java.util.Date;
import java.util.List;

/**
 * Created by Joel on 24-Jul-16.
 */
public class CEvento {
    private String nombre;
    private String descripcion;
    private Date fecha;
    private List<CUsuario> administradores;
    private LatLng ubicacion;
    private String direccion;
    private String especificaciones;
    private List<CUsuario> asistiran;
    private Constants.TipoEvento tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<CUsuario> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<CUsuario> administradores) {
        this.administradores = administradores;
    }

    public LatLng getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(LatLng ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public List<CUsuario> getAsistiran() {
        return asistiran;
    }

    public void setAsistiran(List<CUsuario> asistiran) {
        this.asistiran = asistiran;
    }

    public Constants.TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(Constants.TipoEvento tipo) {
        this.tipo = tipo;
    }
}
