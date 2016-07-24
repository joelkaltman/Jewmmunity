package com.bigbambu.jewmmunity.Clases;

import java.util.Date;
import java.util.List;

/**
 * Created by Joel on 24-Jul-16.
 */
public class CViaje {
    private String destino;
    private int precio;
    private Date fecha_salida;
    private Date fecha_vuelta;
    private String requisitos;
    private List<CUsuario> asistiran;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_vuelta() {
        return fecha_vuelta;
    }

    public void setFecha_vuelta(Date fecha_vuelta) {
        this.fecha_vuelta = fecha_vuelta;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public List<CUsuario> getAsistiran() {
        return asistiran;
    }

    public void setAsistiran(List<CUsuario> asistiran) {
        this.asistiran = asistiran;
    }
}
