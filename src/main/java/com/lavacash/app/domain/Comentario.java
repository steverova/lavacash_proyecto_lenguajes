package com.lavacash.app.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_user;
    private String comentario;
    @ManyToOne()
    private User user;
    private String fecha;
    private int disponibilidad;


    public Comentario() {
    }

    

    public Comentario(int id, int id_user, String comentario, User user, String fecha) {
        this.id = id;
        this.id_user = id_user;
        this.comentario = comentario;
        this.user = user;
        this.fecha = fecha;
    }



    public Comentario(int id, int id_user, String comentario) {
        this.id = id;
        this.id_user = id_user;
        this.comentario = comentario;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String string) {
        this.fecha = string;
    } 

    public int getDisponibilidad() {
        return disponibilidad;
    }



    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
    
    @Override
    public String toString() {
        return "Comentario [comentario=" + comentario + ", id=" + id + ", id_user=" + id_user + "]";
    }






    
    
    
}
