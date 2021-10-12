/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Propietario extends Persona{
    private int IDCliente;
    private String documentoPer;
    private String domicilio;
    private String telefono;
    private int edad;
    private String email;

    public Propietario(int IDCliente, String documentoPer, String domicilio, String telefono, int edad, String email, String tipo_documento, String documento, String nombre, String apellido, Date fecha_Nacimient, String genero, boolean estado) {
        super(tipo_documento, documento, nombre, apellido, fecha_Nacimient, genero, estado);
        this.IDCliente = IDCliente;
        this.documentoPer = documentoPer;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.edad = edad;
        this.email = email;
    }

    public Propietario(int IDCliente, String documentoPer, String domicilio, String telefono, int edad, String email) {
        this.IDCliente = IDCliente;
        this.documentoPer = documentoPer;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.edad = edad;
        this.email = email;
    }
    
    

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getDocumentoPer() {
        return documentoPer;
    }

    public void setDocumentoPer(String documentoPer) {
        this.documentoPer = documentoPer;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
