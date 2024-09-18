package com.project.database.ui;

import com.project.database.service.DatabaseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddRecordFrame extends JFrame {
    private DatabaseService databaseService;
    private String tableName;
    private JPanel inputPanel;
    private JButton addButton;
    private List<JTextField> inputFields;
    private List<String> columnNames;
    private List<String> columnTypes;

    public AddRecordFrame(DatabaseService databaseService, String tableName) {
        this.databaseService = databaseService;
        this.tableName = tableName;
        setTitle("Add Record to " + tableName);
        setSize(500, 400);
        inputFields = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnTypes = new ArrayList<>();
        initUI();
        loadTableStructure();
    }

    private void initUI() {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        addButton = new JButton("Add Record");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(inputPanel), BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
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

    private void addRecord() {
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
            databaseService.addRecord(tableName, columnNames, values);
            JOptionPane.showMessageDialog(this, "Record added successfully!");
            dispose();
        } catch (SQLException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Failed to add record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
