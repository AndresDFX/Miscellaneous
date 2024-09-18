package com.project.database.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO {
    private Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRecord(String tableName, List<String> columns, List<Object> values) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        for (String column : columns) {
            query.append(column).append(", ");
        }
        query.setLength(query.length() - 2);
        query.append(") VALUES (");
        for (int i = 0; i < values.size(); i++) {
            query.append("?, ");
        }
        query.setLength(query.length() - 2);
        query.append(")");

        try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < values.size(); i++) {
                stmt.setObject(i + 1, values.get(i));
            }
            stmt.executeUpdate();
        }
    }

    public List<List<Object>> getAllRecords(String tableName) throws SQLException {
        List<List<Object>> records = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                records.add(row);
            }
        }
        return records;
    }

    public void updateRecord(String tableName, String keyColumn, Object keyValue, List<String> columns, List<Object> values) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
        for (String column : columns) {
            query.append(column).append(" = ?, ");
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE " + keyColumn + " = ?");

        try (PreparedStatement stmt = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < values.size(); i++) {
                stmt.setObject(i + 1, values.get(i));
            }
            stmt.setObject(values.size() + 1, keyValue);
            stmt.executeUpdate();
        }
    }

    public void deleteRecord(String tableName, String keyColumn, Object keyValue) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // Desactivar verificaciones de claves foráneas
            stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
            
            String query = "DELETE FROM " + tableName + " WHERE " + keyColumn + " = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setObject(1, keyValue);
                pstmt.executeUpdate();
            }
            
            // Reactivar verificaciones de claves foráneas
            stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
        }
    }

    public List<String> getAllDatabases() throws SQLException {
        List<String> databases = new ArrayList<>();
        String query = "SHOW DATABASES";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                databases.add(rs.getString(1));
            }
        }
        return databases;
    }

    public List<String> getAllTables(String databaseName) throws SQLException {
        List<String> tables = new ArrayList<>();
        String query = "SHOW TABLES FROM " + databaseName;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("USE " + databaseName);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tables.add(rs.getString(1));
            }
        }
        return tables;
    }

    public List<String> getTableStructure(String tableName) throws SQLException {
        List<String> structure = new ArrayList<>();
        String query = "DESCRIBE " + tableName;

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                structure.add(rs.getString(1) + " " + rs.getString(2));
            }
        }
        return structure;
    }

    public List<List<Object>> executeQuery(String query) throws SQLException {
        List<List<Object>> results = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                results.add(row);
            }
        }
        return results;
    }

    public void createDatabase(String databaseName) throws SQLException {
        String query = "CREATE DATABASE " + databaseName;
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
        }
    }

    public void deleteDatabase(String databaseName) throws SQLException {
        String query = "DROP DATABASE " + databaseName;
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
}
