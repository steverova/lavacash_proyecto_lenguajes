/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavacash.app.domain;

import java.sql.Time;
import java.util.LinkedList;

/**
 *
 * @author fabri
 */
public class ServicioCompuesto extends Servicio  implements ICompuesto{
    
    private LinkedList<Servicio> servicios;

    public ServicioCompuesto(int codigo, int tipo, String nombre, String descripcion, double  precio, int tiempo) {
        super(codigo, tipo, nombre, descripcion, precio, tiempo);
        this.servicios = new LinkedList<>();
    }

    @Override
    public int calcularTiempo() {
        int tiempo = super.getTiempo();
        for (Servicio servicio : servicios) {
            tiempo += servicio.getTiempo();
        }
        return tiempo;
    }

    @Override
    public double calcularPrecio() {
        double precio = super.getPrecio();
        for (Servicio servicio : servicios) {
            precio += servicio.calcularPrecio();
        }
        return precio;
    }

    @Override
    public void agregarServicio(Servicio servicio) {
        /*
         * valido si existe un mismo servicio ya que no tiene sentido que
         * existan servicios duplicados.
         */
        if (!existeServicio(servicio)) {
            this.servicios.add(servicio);
        }
    }
    
    boolean esCompuesto() {
        return true;
    }

    @Override
    public void removerServicio(Servicio servicio) {
        for (Servicio serv : servicios) {
            if ( serv.getId() == servicio.getId() ) {
                this.servicios.remove(serv);
            }
        }
    }
    
    private boolean existeServicio(Servicio servicio) {
        boolean answer = false;
        for (Servicio serv : servicios) {
            if ( serv.getId() == servicio.getId() ) {
                answer = true;
            }
        }
        return answer;
    }

    @Override
    public String toString() {
        return "ServicioCompuesto{" + "servicios=" + servicios.toString() + '}' + super.toString();
    }

}
