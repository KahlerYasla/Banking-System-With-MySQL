package com.javadatabase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankaMusteriMenu extends JFrame implements ActionListener {
    private JButton viewAccountsButton;
    private JButton transactionButton;
    private JButton logoutButton;
    private JButton krediButton;

    public BankaMusteriMenu() {
        // Set up the frame
        setTitle("Banka Müşteri Menüsü");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main menu panel
        JPanel mainMenuPanel = new JPanel(new GridLayout(2, 1));
        mainMenuPanel.setBackground(Color.DARK_GRAY);
        mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        viewAccountsButton = new JButton("Hesaplari Görüntüle");
        viewAccountsButton.addActionListener(this);
        mainMenuPanel.add(viewAccountsButton);

        transactionButton = new JButton("Islem Yap");
        transactionButton.addActionListener(this);
        mainMenuPanel.add(transactionButton);

        krediButton = new JButton("Kredi sonuçlarini görüntüle");
        krediButton.addActionListener(this);
        mainMenuPanel.add(krediButton);

        logoutButton = new JButton("Çikis");
        logoutButton.addActionListener(this);
        mainMenuPanel.add(logoutButton);

        // Add the main menu panel to the frame
        add(mainMenuPanel, BorderLayout.CENTER);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == viewAccountsButton) {
            // Open the Hesaplari Görüntüle window
            AccountOverviewWindow accountsWindow = new AccountOverviewWindow();
            accountsWindow.setVisible(true);
        } else if (e.getSource() == transactionButton) {
            // Open the Islem Yap window
            TransactionWindow transactionWindow = new TransactionWindow();
            transactionWindow.setVisible(true);
        } else if (e.getSource() == krediButton) {
            // Open the Kredi sonuçlarini görüntüle window
            CreditResultsWindow creditWindow = new CreditResultsWindow();
            creditWindow.setVisible(true);
        } else if (e.getSource() == logoutButton) {
            // Close the main menu window
            setVisible(false);
            // Open the login window
            MenuGUI login = new MenuGUI();
            login.setVisible(true);
        }
    }
    
}
