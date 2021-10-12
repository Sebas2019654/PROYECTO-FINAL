/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Arust
 */
public class Estacionamiento {

    private String num_area;
    private String nro_Placa;
    private Date fecha;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    private double precio = 1;
    private double tarifa;

    public Estacionamiento(String num_area, String nro_Placa, Date fecha, LocalTime hora_entrada, LocalTime hora_salida, double tarifa) {
        this.num_area = num_area;
        this.nro_Placa = nro_Placa;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.tarifa = tarifa;
    }

    public Estacionamiento(String num_area, String nro_Placa, Date fecha, LocalTime hora_entrada) {
        this.num_area = num_area;
        this.nro_Placa = nro_Placa;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
    }

    public Estacionamiento(String nro_Placa, LocalTime hora_salida) {
        this.nro_Placa = nro_Placa;
        this.hora_salida = hora_salida;
    }

    public Estacionamiento(String nro_Placa, double tarifa) {
        this.nro_Placa = nro_Placa;
        this.tarifa = tarifa;
    }
    
    

    public String getNum_area() {
        return num_area;
    }

    public void setNum_area(String num_area) {
        this.num_area = num_area;
    }

    public String getNro_Placa() {
        return nro_Placa;
    }

    public void setNro_Placa(String nro_Placa) {
        this.nro_Placa = nro_Placa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    
}
