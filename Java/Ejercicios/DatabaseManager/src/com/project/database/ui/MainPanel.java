package com.project.database.ui;

import com.project.database.service.DatabaseService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MainPanel extends JPanel {
    private DatabaseService databaseService;
    private JComboBox<String> databaseComboBox;
    private JComboBox<String> tableComboBox;
    private JTextArea tableStructureTextArea;
    private JTable queryResultTable;
    private JComboBox<String> conditionFieldComboBox1;
    private JComboBox<String> conditionOperatorComboBox1;
    private JTextField conditionValueField1;
    private JComboBox<String> conditionFieldComboBox2;
    private JComboBox<String> conditionOperatorComboBox2;
    private JTextField conditionValueField2;
    private JTextField viewNameField;
    private JComboBox<String> conditionLogicComboBox;
    private JButton executeQueryButton;
    private JButton createViewButton;
    private JButton createDatabaseButton;
    private JButton deleteDatabaseButton;
    private JButton loadTablesButton;
    private JButton showCRUDButton;
    private JButton addRecordButton;

    public MainPanel(DatabaseService databaseService) {
        this.databaseService = databaseService;
        initUI();
        loadDatabases();
    }

    private void initUI() {
        JTabbedPane tabbedPane = new JTabbedPane();

        // Pestaña de Bases de Datos
        JPanel databasePanel = new JPanel(new GridLayout(2, 2));
        databasePanel.setBackground(new Color(204, 229, 255));
        databaseComboBox = new JComboBox<>();
        createDatabaseButton = new JButton("Create Database");
        deleteDatabaseButton = new JButton("Delete Database");

        createDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDatabase();
            }
        });

        deleteDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDatabase();
            }
        });

        databasePanel.add(new JLabel("Databases:"));
        databasePanel.add(databaseComboBox);
        databasePanel.add(createDatabaseButton);
        databasePanel.add(deleteDatabaseButton);
        tabbedPane.add("Databases", databasePanel);

        // Pestaña de Tablas
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(new Color(255, 229, 204));
        tableComboBox = new JComboBox<>();
        tableStructureTextArea = new JTextArea(10, 30);
        loadTablesButton = new JButton("Load Tables");

        loadTablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTables();
            }
        });

        JPanel tableControlPanel = new JPanel(new GridLayout(2, 2));
        tableControlPanel.add(new JLabel("Tables:"));
        tableControlPanel.add(tableComboBox);
        tableControlPanel.add(loadTablesButton);

        tablePanel.add(tableControlPanel, BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(tableStructureTextArea), BorderLayout.CENTER);
        tabbedPane.add("Tables", tablePanel);

        // Pestaña de Consultas
        JPanel queryPanel = new JPanel();
        queryPanel.setBackground(new Color(229, 255, 204));
        
        JLabel condition1Label = new JLabel("Condition 1:");
        conditionFieldComboBox1 = new JComboBox<>();
        conditionOperatorComboBox1 = new JComboBox<>(new String[]{"<", ">", "<=", ">=", "=", "<>", "LIKE", "NOT LIKE", "IS NULL", "IS NOT NULL"});
        conditionValueField1 = new JTextField(20);

        JLabel conditionLogicLabel = new JLabel("Condition Logic:");
        conditionLogicComboBox = new JComboBox<>(new String[]{"AND", "OR"});

        JLabel condition2Label = new JLabel("Condition 2:");
        conditionFieldComboBox2 = new JComboBox<>();
        conditionOperatorComboBox2 = new JComboBox<>(new String[]{"<", ">", "<=", ">=", "=", "<>", "LIKE", "NOT LIKE", "IS NULL", "IS NOT NULL"});
        conditionValueField2 = new JTextField(20);

        JLabel viewNameLabel = new JLabel("View Name:");
        viewNameField = new JTextField(20);

        executeQueryButton = new JButton("Execute Query");
        createViewButton = new JButton("Create View");
        
        queryResultTable = new JTable(new DefaultTableModel());
        JScrollPane queryResultScrollPane = new JScrollPane(queryResultTable);

        executeQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeQuery();
            }
        });

        createViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createView();
            }
        });

        GroupLayout layout = new GroupLayout(queryPanel);
        queryPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(condition1Label)
                    .addComponent(conditionLogicLabel)
                    .addComponent(condition2Label)
                    .addComponent(viewNameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conditionFieldComboBox1)
                        .addComponent(conditionOperatorComboBox1)
                        .addComponent(conditionValueField1))
                    .addComponent(conditionLogicComboBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conditionFieldComboBox2)
                        .addComponent(conditionOperatorComboBox2)
                        .addComponent(conditionValueField2))
                    .addComponent(viewNameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(executeQueryButton)
                    .addComponent(createViewButton))
                .addComponent(queryResultScrollPane)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(condition1Label)
                    .addComponent(conditionFieldComboBox1)
                    .addComponent(conditionOperatorComboBox1)
                    .addComponent(conditionValueField1))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(conditionLogicLabel)
                    .addComponent(conditionLogicComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(condition2Label)
                    .addComponent(conditionFieldComboBox2)
                    .addComponent(conditionOperatorComboBox2)
                    .addComponent(conditionValueField2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(viewNameLabel)
                    .addComponent(viewNameField)
                    .addComponent(executeQueryButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(createViewButton))
                .addComponent(queryResultScrollPane)
        );

        tabbedPane.add("Queries", queryPanel);

        // Pestaña de CRUD
        JPanel crudPanel = new JPanel(new BorderLayout());
        crudPanel.setBackground(new Color(255, 204, 204));
        showCRUDButton = new JButton("Show CRUD Operations");
        addRecordButton = new JButton("Add Record");

        showCRUDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCRUDOperations();
            }
        });

        addRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        JPanel crudControlPanel = new JPanel(new GridLayout(1, 2));
        crudControlPanel.add(showCRUDButton);
        crudControlPanel.add(addRecordButton);

        crudPanel.add(crudControlPanel, BorderLayout.NORTH);
        tabbedPane.add("CRUD", crudPanel);

        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);

        databaseComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTables();
            }
        });

        tableComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTableStructure();
                loadFieldsForConditions();
            }
        });
    }

    private void loadDatabases() {
        try {
            List<String> databases = databaseService.getAllDatabases();
            databaseComboBox.removeAllItems();
            for (String db : databases) {
                databaseComboBox.addItem(db);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to load databases: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTables() {
        String selectedDatabase = (String) databaseComboBox.getSelectedItem();
        System.out.println("Selected database: " + selectedDatabase);
        if (selectedDatabase != null) {
            try {
                List<String> tables = databaseService.getAllTables(selectedDatabase);
                System.out.println("Tables: " + tables);
                tableComboBox.removeAllItems();
                for (String table : tables) {
                    tableComboBox.addItem(table);
                }
            } catch (SQLException ex) {
                System.err.println("Failed to load tables: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Failed to load tables: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadTableStructure() {
        String selectedTable = (String) tableComboBox.getSelectedItem();
        System.out.println("Selected table: " + selectedTable);
        if (selectedTable != null) {
            try {
                List<String> structure = databaseService.getTableStructure(selectedTable);
                System.out.println("Table structure: " + structure);
                tableStructureTextArea.setText("");
                for (String column : structure) {
                    tableStructureTextArea.append(column + "\n");
                }
            } catch (SQLException ex) {
                System.err.println("Failed to load table structure: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Failed to load table structure: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadFieldsForConditions() {
        String selectedTable = (String) tableComboBox.getSelectedItem();
        if (selectedTable != null) {
            try {
                List<String> structure = databaseService.getTableStructure(selectedTable);
                conditionFieldComboBox1.removeAllItems();
                conditionFieldComboBox2.removeAllItems();
                for (String column : structure) {
                    String columnName = column.split(" ")[0];
                    conditionFieldComboBox1.addItem(columnName);
                    conditionFieldComboBox2.addItem(columnName);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to load fields for conditions: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void executeQuery() {
        String selectedTable = (String) tableComboBox.getSelectedItem();
        String conditionField1 = (String) conditionFieldComboBox1.getSelectedItem();
        String conditionOperator1 = (String) conditionOperatorComboBox1.getSelectedItem();
        String conditionValue1 = conditionValueField1.getText().trim();
        String conditionLogic = (String) conditionLogicComboBox.getSelectedItem();
        String conditionField2 = (String) conditionFieldComboBox2.getSelectedItem();
        String conditionOperator2 = (String) conditionOperatorComboBox2.getSelectedItem();
        String conditionValue2 = conditionValueField2.getText().trim();
        if (selectedTable == null) {
            JOptionPane.showMessageDialog(this, "Please select a table", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder query = new StringBuilder("SELECT * FROM " + selectedTable);
        if (conditionField1 != null && conditionOperator1 != null && !conditionValue1.isEmpty()) {
            query.append(" WHERE ").append(conditionField1).append(" ").append(conditionOperator1).append(" ").append(conditionOperator1.contains("LIKE") ? "'%" + conditionValue1 + "%'" : conditionValue1);
            if (conditionField2 != null && conditionOperator2 != null && !conditionValue2.isEmpty()) {
                query.append(" ").append(conditionLogic).append(" ").append(conditionField2).append(" ").append(conditionOperator2).append(" ").append(conditionOperator2.contains("LIKE") ? "'%" + conditionValue2 + "%'" : conditionValue2);
            }
        }

        try {
            List<List<Object>> results = databaseService.executeQuery(query.toString());
            DefaultTableModel model = (DefaultTableModel) queryResultTable.getModel();
            model.setRowCount(0);
            if (!results.isEmpty()) {
                List<Object> headers = results.get(0);
                model.setColumnIdentifiers(headers.toArray());
                for (List<Object> row : results.subList(1, results.size())) {
                    model.addRow(row.toArray());
                }
            }
        } catch (SQLException ex) {
            System.err.println("Failed to execute query: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to execute query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createDatabase() {
        String databaseName = JOptionPane.showInputDialog(this, "Enter the name of the new database:");
        if (databaseName == null || databaseName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Database name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            databaseService.createDatabase(databaseName);
            JOptionPane.showMessageDialog(this, "Database created successfully!");
            loadDatabases();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to create database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDatabase() {
        String selectedDatabase = (String) databaseComboBox.getSelectedItem();
        if (selectedDatabase == null) {
            JOptionPane.showMessageDialog(this, "Please select a database to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the database " + selectedDatabase + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                databaseService.deleteDatabase(selectedDatabase);
                JOptionPane.showMessageDialog(this, "Database deleted successfully!");
                loadDatabases();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to delete database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void createView() {
        String selectedTable = (String) tableComboBox.getSelectedItem();
        String conditionField1 = (String) conditionFieldComboBox1.getSelectedItem();
        String conditionOperator1 = (String) conditionOperatorComboBox1.getSelectedItem();
        String conditionValue1 = conditionValueField1.getText().trim();
        String conditionLogic = (String) conditionLogicComboBox.getSelectedItem();
        String conditionField2 = (String) conditionFieldComboBox2.getSelectedItem();
        String conditionOperator2 = (String) conditionOperatorComboBox2.getSelectedItem();
        String conditionValue2 = conditionValueField2.getText().trim();
        String viewName = viewNameField.getText().trim();
        if (selectedTable == null) {
            JOptionPane.showMessageDialog(this, "Please select a table", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (viewName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "View name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder query = new StringBuilder("CREATE VIEW " + viewName + " AS SELECT * FROM " + selectedTable);
        if (conditionField1 != null && conditionOperator1 != null && !conditionValue1.isEmpty()) {
            query.append(" WHERE ").append(conditionField1).append(" ").append(conditionOperator1).append(" ").append(conditionOperator1.contains("LIKE") ? "'%" + conditionValue1 + "%'" : conditionValue1);
            if (conditionField2 != null && conditionOperator2 != null && !conditionValue2.isEmpty()) {
                query.append(" ").append(conditionLogic).append(" ").append(conditionField2).append(" ").append(conditionOperator2).append(" ").append(conditionOperator2.contains("LIKE") ? "'%" + conditionValue2 + "%'" : conditionValue2);
            }
        }

        try {
            databaseService.executeQuery(query.toString());
            JOptionPane.showMessageDialog(this, "View created successfully!");
        } catch (SQLException ex) {
            System.err.println("Failed to create view: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Failed to create view: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addRecord() {
        String selectedTable = (String) tableComboBox.getSelectedItem();
        if (selectedTable == null) {
            JOptionPane.showMessageDialog(this, "Please select a table", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new AddRecordFrame(databaseService, selectedTable).setVisible(true);
    }

    private void showCRUDOperations() {
        String selectedTable = (String) tableComboBox.getSelectedItem();
        if (selectedTable != null) {
            new CRUDFrame(databaseService, selectedTable).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a table", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
