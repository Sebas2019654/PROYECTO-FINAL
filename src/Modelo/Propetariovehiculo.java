/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Brayan
 */
public class Propetariovehiculo {
    private String documento;
   private  String codi;
   private  String numplaca;

    public Propetariovehiculo(String documento, String codi, String numplaca) {
        this.documento = documento;
        this.codi = codi;
        this.numplaca = numplaca;
    }

    public Propetariovehiculo(String documento, String numplaca) {
        this.documento = documento;
        this.numplaca = numplaca;
    }

    public Propetariovehiculo() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNumplaca() {
        return numplaca;
    }

    public void setNumplaca(String numplaca) {
        this.numplaca = numplaca;
    }
    
}
