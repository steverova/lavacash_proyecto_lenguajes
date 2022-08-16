package com.lavacash.app.domain;

import java.sql.Date;
import java.sql.Time;

public class Reporte {
    private Date fecha;
    private Time hora;
    private int tipoVehiculo;
    private String placa;
    private String nombreUsuario;
    private String telefono; 
    private int tipoServicio;
    private String nombreServicio;
    private int precio;
    private int tiempo;

    public Reporte(Date fecha, Time hora, int tipoVehiculo, String placa, String nombreUsuario, String telefono, int tipoServicio, String nombreServicio, int precio, int tiempo) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.nombreUsuario = nombreUsuario;
        this.telefono = telefono;
        this.tipoServicio = tipoServicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.tiempo = tiempo;
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

    public int getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(int tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
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
        return "Reporte{" + "fecha=" + fecha + ", hora=" + hora + ", tipoVehiculo=" + tipoVehiculo + ", placa=" + placa + ", nombreUsuario=" + nombreUsuario + ", telefono=" + telefono + ", tipoServicio=" + tipoServicio + ", nombreServicio=" + nombreServicio + ", precio=" + precio + ", tiempo=" + tiempo + '}';
    }
}
