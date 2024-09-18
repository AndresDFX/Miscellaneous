package com.project.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection(String host, int port, String database, String user, String password) throws SQLException {
        String url = "jdbc:mysql://" + host + ":" + port;
        if (database != null && !database.isEmpty()) {
            url += "/" + database;
        }
        url += "?allowPublicKeyRetrieval=true&useSSL=false";
        return DriverManager.getConnection(url, user, password);
    }
}
