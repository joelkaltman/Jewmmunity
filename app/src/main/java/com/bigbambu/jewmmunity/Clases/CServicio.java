package com.bigbambu.jewmmunity.Clases;

import com.bigbambu.jewmmunity.Utiles.Constants;

/**
 * Created by Joel on 24-Jul-16.
 */
public class CServicio {
    private String nombre;
    private String descripcion;
    private int remuneracion;
    private CUsuario administrador;
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

    public int getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(int remuneracion) {
        this.remuneracion = remuneracion;
    }

    public CUsuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(CUsuario administrador) {
        this.administrador = administrador;
    }

    public Constants.RubrosTrabajo getRubro() {
        return rubro;
    }

    public void setRubro(Constants.RubrosTrabajo rubro) {
        this.rubro = rubro;
    }
}
