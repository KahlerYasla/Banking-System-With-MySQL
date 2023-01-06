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

public class BankaciSilWindow extends JFrame implements ActionListener {
    private JTextField nameField;
    private JLabel nameLabel;
    private JButton deleteButton;
    private JButton cancelButton;

    public BankaciSilWindow() {
        // Set up the frame
        setTitle("Bankaci Sil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nameLabel = new JLabel("Bankaci Adi:");
        mainPanel.add(nameLabel);
        nameField = new JTextField();
        mainPanel.add(nameField);
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
        if (e.getSource() == deleteButton) {
            // Get the input value
            String name = nameField.getText();

            // Delete the account
            deleteAccount(name);

            // Close the window
            setVisible(false);
        } else if (e.getSource() == cancelButton) {
            // Close the window
            setVisible(false);
        }
    }

    private void deleteAccount(String name) {
        // Delete the account from the database here

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

            // Sorgu için bir nesne oluşturun
            Statement statement = conn.createStatement();

            // Sorguyu çalıştırın
            statement.executeUpdate("DELETE FROM accounts WHERE name = '" + name + "'");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}