package com.lavacash.app.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnection {
    private final static String DATA = "db_lavacash";
    private final static String USER = "lavacash";
    private final static String PASSWORD = "62!cEB%Dn95#";
    private final static String URL = "jdbc:mysql://208.109.41.231:3306/";
    
    protected Connection conexion;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (this.conexion == null) {
                this.conexion = DriverManager.getConnection(URL + DATA, USER, PASSWORD);
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
}
