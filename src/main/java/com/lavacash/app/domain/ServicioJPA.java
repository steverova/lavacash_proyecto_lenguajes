package com.lavacash.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_servicio")
public class ServicioJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tipo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int tiempo;
    

    public ServicioJPA () {
    }
    
    public ServicioJPA (Servicio servicio) {
        this.id = servicio.getId();
        this.tipo = servicio.getTipo();
        this.nombre = servicio.getNombre();
        this.descripcion = servicio.getDescripcion();
        this.precio = servicio.getPrecio();
        this.tiempo = servicio.getTiempo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "ServicioJPA{" + "id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", tiempo=" + tiempo + '}';
    }
    
    
}
