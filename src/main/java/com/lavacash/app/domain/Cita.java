/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavacash.app.domain;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */

@Entity
@Table(name = "tb_cita")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private Time hora;
    private String detalle;
    private int servicio_id;
    private int vehiculo_id;



    
    
    /*private ServicioJPA servicio;
    private Vehiculo vehiculo;*/
    
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "servicio_id")
    ServicioJPA servicio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cita")
    @JoinColumn(name= "vehiculo_id")
    List<Vehiculo> vehiculo;*/

    public Cita(int id, Date fecha, Time hora, String detalle, int servicio_id, int vehiculo_id) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.detalle = detalle;
        this.servicio_id = servicio_id;
        this.vehiculo_id = vehiculo_id;
    }

    /*public Cita(int id, Date fecha, Time hora, String detalle, ServicioJPA servicio, Vehiculo vehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.detalle = detalle;
        this.servicio = servicio;
        this.vehiculo = vehiculo;
    }*/


    

    public Cita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

   public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getVehiculo_id() {
        return vehiculo_id;
    }

    public void setVehiculo_id(int vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    /*public ServicioJPA getServicio() {
        return servicio;
    }

    public void setServicio(ServicioJPA servicio) {
        this.servicio = servicio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }*/

    

}
