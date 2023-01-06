package com.javadatabase;

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
import java.awt.GridLayout;

public class BankaciDuzenleWindow extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField passwordField;
    private JTextField typeField;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel typeLabel;
    private JButton saveButton;
    private JButton cancelButton;

    public BankaciDuzenleWindow() {
        // Set up the frame
        setTitle("Bankaci Duzenle");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the login panel
        JPanel bankaciDuzenlePanel = new JPanel(new GridLayout(4, 2));
        bankaciDuzenlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Kullanici adi:");
        bankaciDuzenlePanel.add(nameLabel);
        nameField = new JTextField();
        bankaciDuzenlePanel.add(nameField);
        passwordLabel = new JLabel("Sifre:");
        bankaciDuzenlePanel.add(passwordLabel);
        passwordField = new JTextField();
        bankaciDuzenlePanel.add(passwordField);
        typeLabel = new JLabel("Türü (1:Banka Müdürü, 2:Banka Çalışanı, 3:Banka Müşterisi):");
        bankaciDuzenlePanel.add(typeLabel);
        typeField = new JTextField();
        bankaciDuzenlePanel.add(typeField);
        saveButton = new JButton("Kaydet");
        saveButton.addActionListener(this);
        bankaciDuzenlePanel.add(saveButton);
        cancelButton = new JButton("Iptal");
        cancelButton.addActionListener(this);
        bankaciDuzenlePanel.add(cancelButton);

        // Add the login panel to the frame
        add(bankaciDuzenlePanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == saveButton) {
            // Get the input values
            String name = nameField.getText();
            String password = passwordField.getText();
            int type = Integer.parseInt(typeField.getText());

            // Update the account
            updateAccount(name, password, type);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == cancelButton) {
            // Close the window
            setVisible(false);
        }
    }

    private void updateAccount(String name, String password, int type) {

        try {
            // Veritabanı bağlantısı için bir nesne oluşturun
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate("UPDATE bankaci SET password = '" + password + "', type = " + type + " WHERE name = '" + name + "'");

            // Bağlantıyı kapatın
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}