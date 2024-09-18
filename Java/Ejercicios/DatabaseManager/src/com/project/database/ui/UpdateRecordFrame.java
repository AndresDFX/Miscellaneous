package com.project.database.ui;

import com.project.database.service.DatabaseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateRecordFrame extends JFrame {
    private DatabaseService databaseService;
    private String tableName;
    private String keyColumn;
    private Object keyValue;
    private JPanel inputPanel;
    private JButton updateButton;
    private List<JTextField> inputFields;
    private List<String> columnNames;
    private List<String> columnTypes;

    public UpdateRecordFrame(DatabaseService databaseService, String tableName, String keyColumn, Object keyValue) {
        this.databaseService = databaseService;
        this.tableName = tableName;
        this.keyColumn = keyColumn;
        this.keyValue = keyValue;
        setTitle("Update Record in " + tableName);
        setSize(500, 400);
        inputFields = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnTypes = new ArrayList<>();
        initUI();
        loadTableStructure();
        loadRecord();
    }

    private void initUI() {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        updateButton = new JButton("Update Record");

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(inputPanel), BorderLayout.CENTER);
        add(updateButton, BorderLayout.SOUTH);
    }

    private void loadTableStructure() {
        try {
            List<String> structure = databaseService.getTableStructure(tableName);
            for (String column : structure) {
                String[] parts = column.split(" ");
                columnNames.add(parts[0]);
                columnTypes.add(parts[1]);
                JLabel label = new JLabel(parts[0] + " (" + parts[1] + ")");
                JTextField textField = new JTextField(20);
                inputFields.add(textField);
                JPanel fieldPanel = new JPanel(new FlowLayout());
                fieldPanel.add(label);
                fieldPanel.add(textField);
                inputPanel.add(fieldPanel);

                if (parts[1].equalsIgnoreCase("DATE")) {
                    JLabel helpLabel = new JLabel(" (Format: YYYY-MM-DD)");
                    fieldPanel.add(helpLabel);
                }
            }
            validate();
            repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load table structure: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadRecord() {
        try {
            List<List<Object>> records = databaseService.getAllRecords(tableName);
            for (List<Object> record : records) {
                if (record.get(0).equals(keyValue)) {
                    for (int i = 0; i < record.size(); i++) {
                        inputFields.get(i).setText(record.get(i).toString());
                    }
                    break;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRecord() {
        List<Object> values = new ArrayList<>();
        try {
            for (int i = 0; i < inputFields.size(); i++) {
                JTextField textField = inputFields.get(i);
                String value = textField.getText().trim();
                String type = columnTypes.get(i);
                if (type.equalsIgnoreCase("INT")) {
                    values.add(Integer.parseInt(value));
                } else if (type.equalsIgnoreCase("DATE")) {
                    values.add(java.sql.Date.valueOf(value));
                } else {
                    values.add(value);
                }
            }
            databaseService.updateRecord(tableName, keyColumn, keyValue, columnNames, values);
            JOptionPane.showMessageDialog(this, "Record updated successfully!");
            dispose();
        } catch (SQLException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Failed to update record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
