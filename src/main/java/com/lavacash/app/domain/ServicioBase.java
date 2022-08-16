/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavacash.app.domain;


/**
 *
 * @author fabri
 */
public class ServicioBase extends Servicio{
    
    public ServicioBase(int codigo, int tipo, String nombre, String descripcion, double  precio, int tiempo) {
        super(codigo, tipo, nombre, descripcion, precio, tiempo);
    }

    @Override
    public int calcularTiempo() {
        return super.getTiempo();
    }

    @Override
    public double calcularPrecio() {
        return super.getPrecio();
    }

    boolean esCompuesto() {
        return false;
    }

}
