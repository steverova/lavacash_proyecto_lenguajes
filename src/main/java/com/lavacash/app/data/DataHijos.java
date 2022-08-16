/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavacash.app.data;

import com.lavacash.app.domain.Hijo;
import com.lavacash.app.domain.ServicioHijos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabri
 */
public class DataHijos extends DataConnection{

    public DataHijos() {
        super();
    }
    
    public ServicioHijos getHijos (int padre) {
        ServicioHijos answer = new ServicioHijos(padre, new LinkedList<>());
        String query = "CALL sp_recuperar_hijos(?)";
        Connection miConexion = super.getConexion();
        try {
            PreparedStatement pS = miConexion.prepareStatement(query);
            pS.setInt(1, padre);
            ResultSet rS = pS.executeQuery();
            while( rS.next() ) {
                Hijo nHijo = new Hijo( rS.getInt("id"),
                        rS.getString("nombre"),
                        rS.getString("descripcion")
                );
                answer.getHijos().add(nHijo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataHijos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answer;
    }
    
    public boolean guardarHijo (int padre, int hijo) {
        boolean answer = false;
        String query = "CALL sp_insertar_hijo(?, ?)";
        Connection miConexion = super.getConexion();
        try {
            PreparedStatement pS = miConexion.prepareStatement(query);
            pS.setInt(1, padre);
            pS.setInt(2, hijo);
            answer = pS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataHijos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answer;
    }
    
     public boolean reiniciarHijos (int padre) {
        boolean answer = false;
        String query = "CALL sp_reiniciar_hijos(?)";
        Connection miConexion = super.getConexion();
        try {
            PreparedStatement pS = miConexion.prepareStatement(query);
            pS.setInt(1, padre);
            pS.execute();
            answer = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return answer;
    }
}
