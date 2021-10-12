/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 *
 * @author MATUTE
 */
public class Empleados extends Persona  {

    public Empleados(int iDEmpleado, String documentoper, double sueldo, String trabajo, boolean est, String tipo_documento, String documento, String nombre, String apellido, Date fecha_Nacimient, String genero, boolean estado, byte[] foto) {
        super(tipo_documento, documento, nombre, apellido, fecha_Nacimient, genero, estado, foto);
        this.iDEmpleado = iDEmpleado;
        this.documentoper = documentoper;
        this.sueldo = sueldo;
        this.trabajo = trabajo;
        this.est = est;
    }

    private int iDEmpleado;
    private String documentoper;
    private double sueldo;
    private String trabajo;
    private boolean est;

   
    public Empleados(String documentoper, double sueldo, String trabajo, boolean est) {
        this.documentoper = documentoper;
        this.sueldo = sueldo;
        this.trabajo = trabajo;
        this.est = est;
    }

    public Empleados(int iDEmpleado, double sueldo, String trabajo) {
        this.iDEmpleado = iDEmpleado;
        this.sueldo = sueldo;
        this.trabajo = trabajo;
    }

    public int getiDEmpleado() {
        return iDEmpleado;
    }

    public void setiDEmpleado(int iDEmpleado) {
        this.iDEmpleado = iDEmpleado;
    }

    public boolean isEst() {
        return est;
    }

    public void setEst(boolean est) {
        this.est = est;
    }

    public String getDocumentoper() {
        return documentoper;
    }

    public void setDocumentoper(String documentoper) {
        this.documentoper = documentoper;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

}
