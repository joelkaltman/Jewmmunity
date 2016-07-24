package com.bigbambu.jewmmunity.Clases;

import com.bigbambu.jewmmunity.Utiles.Constants;

/**
 * Created by Joel on 24-Jul-16.
 */
public class CTrabajo {
    private String nombre;
    private String descripcion;
    private String requisitos;
    private CComunidad comunidad;
    private int remuneracion;
    private int cantidad_horas;
    private Constants.RubrosTrabajo rubro;

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

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public CComunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(CComunidad comunidad) {
        this.comunidad = comunidad;
    }

    public int getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(int remuneracion) {
        this.remuneracion = remuneracion;
    }

    public int getCantidad_horas() {
        return cantidad_horas;
    }

    public void setCantidad_horas(int cantidad_horas) {
        this.cantidad_horas = cantidad_horas;
    }

    public Constants.RubrosTrabajo getRubro() {
        return rubro;
    }

    public void setRubro(Constants.RubrosTrabajo rubro) {
        this.rubro = rubro;
    }
}
