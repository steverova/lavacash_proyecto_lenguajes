package com.lavacash.app.domain;

import java.sql.Time;

public abstract class Servicio {
    private int id;
    private int tipo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int tiempo;

    public Servicio() {
    }
    
    public Servicio(int id, int tipo, String nombre, String descripcion, double precio, int tiempo) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempo = tiempo;
    }
    
    public abstract int calcularTiempo();
    public abstract double calcularPrecio();

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
    
}