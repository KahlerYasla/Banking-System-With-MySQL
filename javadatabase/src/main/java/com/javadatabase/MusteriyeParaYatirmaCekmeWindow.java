package com.javadatabase;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BorderFactory;

public class MusteriyeParaYatirmaCekmeWindow extends JFrame implements ActionListener {
    private JTextField accountNumberField;
    private JTextField amountField;
    private JLabel accountNumberLabel;
    private JLabel amountLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton cancelButton;

    public MusteriyeParaYatirmaCekmeWindow() {
        // Set up the frame
        setTitle("Musteriye Para Yatirma/Cekme");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(4, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        accountNumberLabel = new JLabel("Hesap Numarası:");
        mainPanel.add(accountNumberLabel);
        accountNumberField = new JTextField();
        mainPanel.add(accountNumberField);
        amountLabel = new JLabel("Miktar:");
        mainPanel.add(amountLabel);
        amountField = new JTextField();
        mainPanel.add(amountField);
        depositButton = new JButton("Yatir");
        depositButton.addActionListener(this);
        mainPanel.add(depositButton);
        withdrawButton = new JButton("Cek");
        withdrawButton.addActionListener(this);
        mainPanel.add(withdrawButton);
        cancelButton = new JButton("Iptal");
        cancelButton.addActionListener(this);
        mainPanel.add(cancelButton);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == depositButton) {
            // Get the input values
            String accountNumber = accountNumberField.getText();
            double amount = Double.parseDouble(amountField.getText());

            // Deposit the money
            deposit(accountNumber, amount);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == withdrawButton) {
            // Get the input values
            String accountNumber = accountNumberField.getText();
            double amount = Double.parseDouble(amountField.getText());

            // Withdraw the money
            withdraw(accountNumber, amount);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == cancelButton) {
            // Close the window
            setVisible(false);
        }
    }

    private void deposit(String accountNumber, double amount) {
        // Deposit the money into the account with the given account number

        // Connect to the database

        try {
            // Veritabanı bağlantısı için bir nesne oluşturun
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate(
                    "UPDATE musteri SET bakiye = bakiye + " + amount + " WHERE hesap_no = " + accountNumber);

            // Bağlantıyı kapatın
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void withdraw(String accountNumber, double amount) {
        // Withdraw the money from the account with the given account number

        // Connect to the database

        try {
            // Veritabanı bağlantısı için bir nesne oluşturun
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate(
                    "UPDATE musteri SET bakiye = bakiye - " + amount + " WHERE hesap_no = " + accountNumber);

            // Bağlantıyı kapatın
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}