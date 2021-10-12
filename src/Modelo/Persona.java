package Modelo;

import java.util.Date;

/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Brayan
 */
public class Persona {

    private String tipo_documento;
    private String documento;
    private String nombre;
    private String apellido;
    private Date fecha_Nacimient;
    private String genero;
    private boolean estado;
    private byte[] foto;

    public Persona(String tipo_documento, String documento, String nombre, String apellido, Date fecha_Nacimient, String genero, boolean estado, byte[] foto) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_Nacimient = fecha_Nacimient;
        this.genero = genero;
        this.estado = estado;
        this.foto = foto;
    }

    public Persona() {

    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Persona(String tipo_documento, String documento, String nombre, String apellido, Date fecha_Nacimient, String genero) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_Nacimient = fecha_Nacimient;
        this.genero = genero;
    }

    public Persona(String tipo_documento, String documento, String nombre, String apellido, Date fecha_Nacimient, String genero, boolean estado) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_Nacimient = fecha_Nacimient;
        this.genero = genero;
        this.estado = estado;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Date getFecha_Nacimient() {
        return fecha_Nacimient;
    }

    public void setFecha_Nacimient(Date fecha_Nacimient) {
        this.fecha_Nacimient = fecha_Nacimient;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
