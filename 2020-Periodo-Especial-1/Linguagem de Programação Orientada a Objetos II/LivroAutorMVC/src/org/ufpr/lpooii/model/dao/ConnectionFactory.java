package org.ufpr.lpooii.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost/lpooiilivroautormvc?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");

    }
}
