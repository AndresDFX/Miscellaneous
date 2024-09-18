package com.project.database.ui;

import com.project.database.service.DatabaseService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CRUDFrame extends JFrame {
    private DatabaseService databaseService;
    private String tableName;
    private JTable recordsTable;
    private JButton deleteButton;
    private JButton updateButton;

    public CRUDFrame(DatabaseService databaseService, String tableName) {
        this.databaseService = databaseService;
        this.tableName = tableName;
        setTitle("CRUD Operations for " + tableName);
        setSize(800, 600);
        initUI();
    }

    private void initUI() {
        recordsTable = new JTable();
        loadRecords();

        deleteButton = new JButton("Delete Selected");
        updateButton = new JButton("Update Selected");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRecords();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSelectedRecords();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(recordsTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadRecords() {
        try {
            List<List<Object>> records = databaseService.getAllRecords(tableName);
            List<String> structure = databaseService.getTableStructure(tableName);
            String[] columnNames = structure.toArray(new String[0]);
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            for (List<Object> record : records) {
                tableModel.addRow(record.toArray());
            }
            recordsTable.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load records: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedRecords() {
        int[] selectedRows = recordsTable.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Please select records to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String keyColumn = "id"; // Change this to your key column
            for (int row : selectedRows) {
                Object keyValue = recordsTable.getValueAt(row, 0); // Assume the first column is the key column
                databaseService.deleteRecord(tableName, keyColumn, keyValue);
            }
            JOptionPane.showMessageDialog(this, "Records deleted successfully!");
            loadRecords();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to delete records: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSelectedRecords() {
        int selectedRow = recordsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a record to update", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object keyValue = recordsTable.getValueAt(selectedRow, 0); // Assume the first column is the key column
        String keyColumn = "id"; // Change this to your key column
        new UpdateRecordFrame(databaseService, tableName, keyColumn, keyValue).setVisible(true);
    }
}
