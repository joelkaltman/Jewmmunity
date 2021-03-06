package com.bigbambu.jewmmunity.Clases;

import android.graphics.drawable.Drawable;

import com.bigbambu.jewmmunity.Utiles.Constants;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Joel on 17-Jul-16.
 */
public class CPublicacion {
    CUsuario usuario;
    String titulo;
    String descripcion;
    Drawable imagen;
    Date fecha;
    private Constants.TipoPublicacion tipo;
    private CEvento evento;

    public static CPublicacion generarPublicacion(CUsuario publicador){
        CPublicacion retornar = new CPublicacion();
        retornar.setTitulo("Titulo1");
        retornar.setDescripcion("Descripcion1");
        retornar.setUsuario(publicador);
        retornar.setFecha(Calendar.getInstance().getTime());
        return retornar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(CUsuario user) {
        this.usuario = user;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date imagen) {
        this.fecha = imagen;
    }
    public Constants.TipoPublicacion getTipo() {
        return tipo;
    }

    public void setTipo(Constants.TipoPublicacion tipo) {
        this.tipo = tipo;
    }

    public CEvento getEvento() {
        return evento;
    }

    public void setEvento(CEvento evento) {
        this.evento = evento;
    }
}
