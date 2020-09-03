/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lia
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/sistemabanco?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");
    }
        
    public static void close(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException {
        if (rs!=null) {
            rs.close();
        }
        if (stmt!=null) {
            stmt.close();
        }
        if (con!=null) {
            con.close();
        }
    }
    
    public static void close(Connection con, PreparedStatement stmt) throws SQLException {
        if (stmt!=null) {
            stmt.close();
        }
        if (con!=null) {
            con.close();
        }
    }
}
