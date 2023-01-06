package com.javadatabase;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankaciEkleWindow extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField passwordField;
    private JTextField typeField;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel typeLabel;
    private JButton saveButton;
    private JButton cancelButton;

    public BankaciEkleWindow() {
        // Set up the frame
        setTitle("Bankaci Ekle");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the login panel
        JPanel bankaciEklePanel = new JPanel(new GridLayout(4, 2));
        bankaciEklePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Kullanici adi:");
        bankaciEklePanel.add(nameLabel);
        nameField = new JTextField();
        bankaciEklePanel.add(nameField);
        passwordLabel = new JLabel("Sifre:");
        bankaciEklePanel.add(passwordLabel);
        passwordField = new JTextField();
        bankaciEklePanel.add(passwordField);
        typeLabel = new JLabel("Türü (1:Banka Müdürü, 2:Banka Çalışanı, 3:Banka Müşterisi):");
        bankaciEklePanel.add(typeLabel);
        typeField = new JTextField();
        bankaciEklePanel.add(typeField);
        saveButton = new JButton("Kaydet");
        saveButton.addActionListener(this);
        bankaciEklePanel.add(saveButton);
        cancelButton = new JButton("Iptal");
        cancelButton.addActionListener(this);

        bankaciEklePanel.add(cancelButton);

        // Add the login panel to the frame
        add(bankaciEklePanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == saveButton) {
            // Get the input values
            String name = nameField.getText();
            String password = passwordField.getText();
            int type = Integer.parseInt(typeField.getText());

            // Add the new account
            addNewAccount(name, password, type);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == cancelButton) {
            // Close the window
            setVisible(false);
        }

    }

    private void addNewAccount(String name, String password, int type) {
        try {
            // Create a new account
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate("INSERT INTO bankaci (name, password, type) VALUES ('" + name + "', '" + password + "', " + type + ")");

            // Bağlantıyı kapatın
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}