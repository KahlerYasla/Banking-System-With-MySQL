package com.javadatabase;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AccountOverviewWindow extends JFrame implements ActionListener {
    private JTable accountsTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JPanel mainPanel;

    public AccountOverviewWindow() {
        // Set up the frame
        setTitle("Hesaplari Görüntüle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Müşteri Adı");
        tableModel.addColumn("Hesap Numarası");
        tableModel.addColumn("Bakiye");

        // Populate the table model with data
        // Replace this with a call to a method that retrieves the data from the
        // database
        Object[][] data = {
                { "John Smith", "123456", 1000.0 },
                { "Jane Smith", "654321", 2000.0 },
                { "Bob Johnson", "112233", 500.0 },
                { "Alice Johnson", "332211", 1500.0 },
                { "Chris Williams", "221133", 3000.0 },
                { "Samantha Williams", "443322", 4000.0 }
        };
        for (Object[] row : data) {
            tableModel.addRow(row);
        }

        // Create the table
        accountsTable = new JTable(tableModel);

        // Create the scroll pane and add the table to it
        scrollPane = new JScrollPane(accountsTable);

        // Create the main panel and add the scroll pane to it
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        // No action required
    }
}

