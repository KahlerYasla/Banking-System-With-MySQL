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

public class KrediOnaylaReddetWindow extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField statusField;
    private JLabel nameLabel;
    private JLabel statusLabel;
    private JButton saveButton;
    private JButton cancelButton;

    public KrediOnaylaReddetWindow() {
        // Set up the frame
        setTitle("Kredi Onayla/Reddet");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Müşteri Adı:");
        mainPanel.add(nameLabel);
        nameField = new JTextField();
        mainPanel.add(nameField);
        statusLabel = new JLabel("Kredi Durumu (1:Onaylandi, 0:Red Edildi):");
        mainPanel.add(statusLabel);
        statusField = new JTextField();
        mainPanel.add(statusField);
        saveButton = new JButton("Kaydet");
        saveButton.addActionListener(this);
        mainPanel.add(saveButton);
        cancelButton = new JButton("Iptal");

        cancelButton.addActionListener(this);
        mainPanel.add(cancelButton);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == saveButton) {

            try {
                // Save the changes made to the customer's credit status
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root",
                        "3755");

                // Sorgu için bir nesne oluşturun
                Statement statement = conn.createStatement();

                // Sorguyu çalıştırın
                String name = nameField.getText();
                String status = statusField.getText();
                String query = "UPDATE kredi SET durum = " + status
                        + " WHERE musteri_id = (SELECT id FROM musteri WHERE name = '" + name + "')";
                statement.executeUpdate(query);

                // Bağlantıyı kapatın
                conn.close();

                // Close the window
                setVisible(false);
                // Open the main menu again
                BankaMuduruMenu mainMenu = new BankaMuduruMenu();
                mainMenu.setVisible(true);

            } catch (SQLException a) {
                // TODO: handle exception
            }

        } else if (e.getSource() == cancelButton) {
            // Close the window without saving any changes
            setVisible(false);

            // Open the main menu again
            BankaMuduruMenu mainMenu = new BankaMuduruMenu();
            mainMenu.setVisible(true);
        }
    }
}
