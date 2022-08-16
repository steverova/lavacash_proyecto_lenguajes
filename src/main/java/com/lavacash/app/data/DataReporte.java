/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lavacash.app.data;

import com.lavacash.app.domain.Reporte;
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
public class DataReporte extends DataConnection{

    public DataReporte() {
        super();
    }
    
    public LinkedList<Reporte> getSalas () {
        LinkedList<Reporte> answer = new LinkedList<>();
        String query = "CALL sp_reporte_select()";
        Connection miConexion = super.getConexion();
        try {
            PreparedStatement pS = miConexion.prepareStatement(query);
            ResultSet rS = pS.executeQuery();
            while( rS.next() ) {
                Reporte newReporte = new Reporte( rS.getDate("fecha"), 
                        rS.getTime("hora"), 
                        rS.getInt("tipoVehiculo"),
                        rS.getString("placa"),
                        rS.getString("nombreUsuario"),
                        rS.getString("telefono"),
                        rS.getInt("tipoServicio"),
                        rS.getString("nombreServicio"),
                        rS.getInt("precio"),
                        rS.getInt("tiempo")
                );
                answer.add(newReporte);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answer;
    }
}
