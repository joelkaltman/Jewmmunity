package com.bigbambu.jewmmunity;

/**
 * Created by Joel on 19-Jul-16.
 */
public class CUsuario {
    private String usuario;
    private String contrasenia;
    private String nombre;
    private int puntaje;

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

    public static CUsuario generarUsuario(String usuario) {
        CUsuario retornar = new CUsuario();
        retornar.setUsuario(usuario);
        retornar.setContrasenia("1234");
        retornar.setNombre(usuario);
        retornar.setPuntaje(0);
        return retornar;
    }


}
