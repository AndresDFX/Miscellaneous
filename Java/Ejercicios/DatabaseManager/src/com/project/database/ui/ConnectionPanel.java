package com.project.database.ui;

import com.project.database.connection.DatabaseConnection;
import com.project.database.service.DatabaseService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPanel extends JPanel {
    private JTextField hostField;
    private JTextField portField;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton connectButton;
    private DatabaseService databaseService;
    private MainFrame mainFrame;

    public ConnectionPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initUI();
    }

    private void initUI() {
        JLabel titleLabel = new JLabel("Database Connection");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        hostField = new JTextField("localhost");
        portField = new JTextField("3306");
        userField = new JTextField();
        passwordField = new JPasswordField();

        connectButton = new JButton("Connect");
        connectButton.setBackground(new Color(0, 102, 204));
        connectButton.setForeground(Color.WHITE);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToDatabase();
            }
        });

        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Host:"));
        formPanel.add(hostField);
        formPanel.add(new JLabel("Port:"));
        formPanel.add(portField);
        formPanel.add(new JLabel("User:"));
        formPanel.add(userField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel());
        formPanel.add(connectButton);

        add(titleLabel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
    }

    private void connectToDatabase() {
        String host = hostField.getText();
        int port;
        try {
            port = Integer.parseInt(portField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Port must be a number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String user = userField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection connection = DatabaseConnection.getConnection(host, port, null, user, password);
            databaseService = new DatabaseService(connection);
            JOptionPane.showMessageDialog(this, "Connected to database successfully!");
            mainFrame.setDatabaseService(databaseService);
            mainFrame.showMainPanel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
