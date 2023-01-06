package com.javadatabase;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MusteriEkleSilWindow extends JFrame implements ActionListener {
    private JTextField nameField;
    private JLabel nameLabel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton cancelButton;

    public MusteriEkleSilWindow() {
        // Set up the frame
        setTitle("Musteri Ekle/Sil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Müşteri Adı:");
        mainPanel.add(nameLabel);
        nameField = new JTextField();
        mainPanel.add(nameField);
        addButton = new JButton("Ekle");
        addButton.addActionListener(this);
        mainPanel.add(addButton);
        deleteButton = new JButton("Sil");
        deleteButton.addActionListener(this);
        mainPanel.add(deleteButton);
        cancelButton = new JButton("Iptal");
        cancelButton.addActionListener(this);
        mainPanel.add(cancelButton);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == addButton) {
            // Get the input value
            String name = nameField.getText();

            // Add the customer
            addCustomer(name);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == deleteButton) {
            // Get the input value
            String name = nameField.getText();

            // Delete the customer
            deleteCustomer(name);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == cancelButton) {
            // Close the window
            setVisible(false);
        }

    }

    private void addCustomer(String name) {
        // Add the customer to the database here

        // Connect to the database

        try {
            // Veritabanı bağlantısı için bir nesne oluşturun
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate("INSERT INTO musteri (musteri_adi) VALUES ('" + name + "')");

            // Bağlantıyı kapatın
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void deleteCustomer(String name) {
        // Delete the customer from the database here

        // Connect to the database

        try {
            // Veritabanı bağlantısı için bir nesne oluşturun
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate("DELETE FROM musteri WHERE musteri_adi = '" + name + "'");

            // Bağlantıyı kapatın
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}