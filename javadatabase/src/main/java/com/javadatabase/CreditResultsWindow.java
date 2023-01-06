package com.javadatabase;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CreditResultsWindow extends JFrame implements ActionListener {
    private JTable creditResultsTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JPanel mainPanel;

    public CreditResultsWindow() {
        // Set up the frame
        setTitle("Kredi Sonuçlarını Görüntüle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Müşteri Adı");
        tableModel.addColumn("Kredi Miktarı");
        tableModel.addColumn("Vade Tarihi");
        tableModel.addColumn("Faiz Oranı");

        // Populate the table model with data
        // Replace this with a call to a method that retrieves the data from the
        // database
        Object[][] data = {
                { "John Smith", 1000.0, "01/01/2022", 0.05 },
                { "Jane Smith", 2000.0, "01/01/2023", 0.07 },
                { "Bob Johnson", 3000.0, "01/01/2024", 0.09 },
        };
        for (Object[] row : data) {
            tableModel.addRow(row);
        }

        // Create the table
        creditResultsTable = new JTable(tableModel);

        // Add the table to a scroll pane
        scrollPane = new JScrollPane(creditResultsTable);

        // Add the scroll pane to the main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        // No action needed for this window
    }
}