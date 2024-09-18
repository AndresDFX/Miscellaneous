package com.project.database.service;

import com.project.database.dao.GenericDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DatabaseService {
    private GenericDAO genericDAO;

    public DatabaseService(Connection connection) {
        this.genericDAO = new GenericDAO(connection);
    }

    public void addRecord(String tableName, List<String> columns, List<Object> values) throws SQLException {
        genericDAO.addRecord(tableName, columns, values);
    }

    public List<List<Object>> getAllRecords(String tableName) throws SQLException {
        return genericDAO.getAllRecords(tableName);
    }

    public void updateRecord(String tableName, String keyColumn, Object keyValue, List<String> columns, List<Object> values) throws SQLException {
        genericDAO.updateRecord(tableName, keyColumn, keyValue, columns, values);
    }

    public void deleteRecord(String tableName, String keyColumn, Object keyValue) throws SQLException {
        genericDAO.deleteRecord(tableName, keyColumn, keyValue);
    }

    public List<String> getAllDatabases() throws SQLException {
        return genericDAO.getAllDatabases();
    }

    public List<String> getAllTables(String databaseName) throws SQLException {
        return genericDAO.getAllTables(databaseName);
    }

    public List<String> getTableStructure(String tableName) throws SQLException {
        return genericDAO.getTableStructure(tableName);
    }

    public List<List<Object>> executeQuery(String query) throws SQLException {
        return genericDAO.executeQuery(query);
    }

    public void createDatabase(String databaseName) throws SQLException {
        genericDAO.createDatabase(databaseName);
    }

    public void deleteDatabase(String databaseName) throws SQLException {
        genericDAO.deleteDatabase(databaseName);
    }
}
