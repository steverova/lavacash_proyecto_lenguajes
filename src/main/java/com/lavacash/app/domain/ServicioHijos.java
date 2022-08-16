/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavacash.app.domain;

import java.util.LinkedList;

/**
 *
 * @author Fabricio
 */
public class ServicioHijos {
    private int id;
    private LinkedList<Hijo> hijos;

    public ServicioHijos(int id, LinkedList<Hijo> hijos) {
        this.id = id;
        this.hijos = hijos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(LinkedList<Hijo> hijos) {
        this.hijos = hijos;
    }
    
    
}
