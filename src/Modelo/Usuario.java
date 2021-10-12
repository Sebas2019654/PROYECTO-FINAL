/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.ArrayList;
/**
 *
 * @author MATUTE
 */
public class Usuario {

    private String nombre;
    private String apellido;
    private String nick;
    private String contrasena;
    private String rango;
    private boolean estado;
    private int rol;
    private String codrecuperar;

    public String getCodrecuperar() {
        return codrecuperar;
    }

    public void setCodrecuperar(String codrecuperar) {
        this.codrecuperar = codrecuperar;
    }

    public Usuario(String nombre, String apellido, String nick, String contrasena, String rango, boolean estado, int rol, String codrecuperar) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.contrasena = contrasena;
        this.rango = rango;
        this.estado = estado;
        this.rol = rol;
        this.codrecuperar = codrecuperar;
    }
    public Usuario(String nombre, String apellido, String nick, String contrasena, String rango, boolean estado, int rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.contrasena = contrasena;
        this.rango = rango;
        this.estado = estado;
        this.rol = rol;
    }

  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

  
  
}
