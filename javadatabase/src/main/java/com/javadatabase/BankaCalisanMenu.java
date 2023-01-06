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

public class BankaCalisanMenu extends JFrame implements ActionListener {
    private JButton createAccountButton;
    private JButton viewAccountsButton;
    private JButton transactionButton;
    private JButton logoutButton;

    public BankaCalisanMenu() {
        // Set up the frame
        setTitle("Banka Çalışanı Menüsü");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main menu panel
        JPanel mainMenuPanel = new JPanel(new GridLayout(3, 1));
        mainMenuPanel.setBackground(Color.DARK_GRAY);
        mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        createAccountButton = new JButton("Müsteriye Yeni Hesap Olustur");
        createAccountButton.addActionListener(this);
        mainMenuPanel.add(createAccountButton);

        viewAccountsButton = new JButton("Müsteri Ekle/Sil");
        viewAccountsButton.addActionListener(this);
        mainMenuPanel.add(viewAccountsButton);

        transactionButton = new JButton("Müsteriye Para Yatirma/Cekme");
        transactionButton.addActionListener(this);
        mainMenuPanel.add(transactionButton);

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
        if (e.getSource() == createAccountButton) {
            // Open the Müsteriye Yeni Hesap Olustur menu
            MusteriyeYeniHesapOlusturWindow window = new MusteriyeYeniHesapOlusturWindow();
            window.setVisible(true);
        } else if (e.getSource() == viewAccountsButton) {
            // Open the Müsteri Ekle/Sils window
            MusteriEkleSilWindow window = new MusteriEkleSilWindow();
            window.setVisible(true);
        } else if (e.getSource() == transactionButton) {
            // Open the Müsteriye Para Yatirma/Cekme window
            MusteriyeParaYatirmaCekmeWindow window = new MusteriyeParaYatirmaCekmeWindow();
            window.setVisible(true);
        } else if (e.getSource() == logoutButton) {
            // Close the main menu window
            setVisible(false);
            // Open the login window
            MenuGUI login = new MenuGUI();
            login.setVisible(true);
        }
    }
}
