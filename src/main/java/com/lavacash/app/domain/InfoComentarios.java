package com.lavacash.app.domain;

public class InfoComentarios {

    private int id_comentario;
    private int id;
    private String nombre;
    private String apellido;
    private String image;
    private String asunto;
    private String comentario;
    private int disponibilidad;

    public InfoComentarios() {
    }
    

    public InfoComentarios(int id, String nombre, String apellido, String image, String comentario,
            int disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.image = image;
        this.comentario = comentario;
        this.disponibilidad = disponibilidad;
    }

    
    

    public InfoComentarios(int id_comentario, int id, String nombre, String apellido, String image,
            String comentario, int disponibilidad) {
        this.id_comentario = id_comentario;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.image = image;
        this.asunto = asunto;
        this.comentario = comentario;
        this.disponibilidad = disponibilidad;
    }

    


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getImage() {
        return image;
    }

    public String getComentario() {
        return comentario;
    }

    

    @Override
    public String toString() {
        return "Comentarios [apellido=" + apellido + ", comentario=" + comentario + ", id="
                + id + ", image=" + image + ", nombre=" + nombre + "]";
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    public int getId_comentario() {
        return id_comentario;
    }


    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }


}
