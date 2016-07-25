package com.bigbambu.jewmmunity.Clases;

import java.util.List;

/**
 * Created by Joel on 19-Jul-16.
 */
public class CUsuario {
    private String usuario;
    private String contrasenia;
    private int puntaje;
    private String nombre;
    private String apellido;
    private String apellido_madre;
    private int telefono;
    private List<CComunidad> comunidades;
    private List<CEvento> eventos;
    private List<CUsuario> amigos;

    public static CUsuario generarUsuario(String usuario) {
        CUsuario retornar = new CUsuario();
        retornar.setUsuario(usuario);
        retornar.setContrasenia("1234");
        retornar.setNombre(usuario);
        retornar.setPuntaje(0);
        retornar.setNombre("Juan");
        retornar.setApellido("Perenovich");
        retornar.setApellido_madre("Lubtzcgigjhgvgajhgavich");
        retornar.setTelefono(44444444);
        return retornar;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido_madre() {
        return apellido_madre;
    }

    public void setApellido_madre(String apellido_madre) {
        this.apellido_madre = apellido_madre;
    }

    public List<CComunidad> getComunidades() {
        return comunidades;
    }

    public void setComunidades(List<CComunidad> comunidades) {
        this.comunidades = comunidades;
    }

    public List<CEvento> getEventos() {
        return eventos;
    }

    public void setEventos(List<CEvento> eventos) {
        this.eventos = eventos;
    }

    public List<CUsuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<CUsuario> amigos) {
        this.amigos = amigos;
    }
}
