package com.javadatabase;

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
import java.awt.GridLayout;

public class MusteriyeYeniHesapOlusturWindow extends JFrame implements ActionListener {
  private JTextField nameField;
  private JTextField accountNumberField;
  private JTextField balanceField;
  private JLabel nameLabel;
  private JLabel accountNumberLabel;
  private JLabel balanceLabel;
  private JButton createButton;
  private JButton cancelButton;

  public MusteriyeYeniHesapOlusturWindow() {
    // Set up the frame
    setTitle("Musteriye Yeni Hesap Olustur");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Create the main panel
    JPanel mainPanel = new JPanel(new GridLayout(4, 2

    ));
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    nameLabel = new JLabel("Müşteri Adı:");
    mainPanel.add(nameLabel);
    nameField = new JTextField();
    mainPanel.add(nameField);
    accountNumberLabel = new JLabel("Hesap Numarası:");
    mainPanel.add(accountNumberLabel);
    accountNumberField = new JTextField();
    mainPanel.add(accountNumberField);
    balanceLabel = new JLabel("Bakiye:");
    mainPanel.add(balanceLabel);
    balanceField = new JTextField();
    mainPanel.add(balanceField);
    createButton = new JButton("Oluştur");
    createButton.addActionListener(this);
    mainPanel.add(createButton);
    cancelButton = new JButton("Iptal");
    cancelButton.addActionListener(this);
    mainPanel.add(cancelButton);

    // Add the main panel to the frame
    add(mainPanel, BorderLayout.CENTER);

  }

  public void actionPerformed(ActionEvent e) {
    // Check which button was clicked
    if (e.getSource() == createButton) {
      // Get the input values
      String name = nameField.getText();
      String accountNumber = accountNumberField.getText();
      double balance = Double.parseDouble(balanceField.getText());

      // Create the new account
      createNewAccount(name, accountNumber, balance);

      // Close the window
      setVisible(false);
    } else if (e.getSource() == cancelButton) {
      // Close the window
      setVisible(false);
    }
  }

  private void createNewAccount(String name, String accountNumber, double balance) {
    // Create the new account in the database here

    // Connect to the database

    try {
      // Veritabanı bağlantısı için bir nesne oluşturun
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

      // Sorgu için bir nesne oluşturun
      Statement statement = conn.createStatement();

      // Sorguyu çalıştırın
      statement.executeUpdate("INSERT INTO musteri (name, hesap_no, bakiye) VALUES ('" + name + "', '" + accountNumber
          + "', '" + balance + "')");

      // Bağlantıyı kapatın
      conn.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    
  }
}