package com.project.database.ui;

import com.project.database.service.DatabaseService;

import javax.swing.*;

public class MainFrame extends JFrame {
    private DatabaseService databaseService;
    private ConnectionPanel connectionPanel;
    private MainPanel mainPanel;

    public MainFrame() {
        setTitle("Database Management Tool");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        connectionPanel = new ConnectionPanel(this);
        setContentPane(connectionPanel);
    }

    public void setDatabaseService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void showMainPanel() {
        if (mainPanel == null) {
            mainPanel = new MainPanel(databaseService);
        }
        setContentPane(mainPanel);
        validate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
