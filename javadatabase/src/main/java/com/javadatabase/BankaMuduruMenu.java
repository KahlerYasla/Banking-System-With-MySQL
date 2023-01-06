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

public class BankaMuduruMenu extends JFrame implements ActionListener {
    private JButton bankaciEkleButton;
    private JButton bankaciDuzenleButton;
    private JButton bankaciSilButton;
    private JButton krediOnaylaReddetButton;
    private JButton logoutButton;

    public BankaMuduruMenu() {
        // Set up the frame
        setTitle("Ana Menü");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main menu panel
        JPanel mainMenuPanel = new JPanel(new GridLayout(4, 1));
        mainMenuPanel.setBackground(Color.DARK_GRAY);
        mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        bankaciEkleButton = new JButton("Yeni Bankaci Ekle");
        bankaciEkleButton.addActionListener(this);
        mainMenuPanel.add(bankaciEkleButton);
        bankaciDuzenleButton = new JButton("Bankaci Düzenle");
        bankaciDuzenleButton.addActionListener(this);
        mainMenuPanel.add(bankaciDuzenleButton);
        bankaciSilButton = new JButton("Bankaci Sil");
        bankaciSilButton.addActionListener(this);
        mainMenuPanel.add(bankaciSilButton);

        krediOnaylaReddetButton = new JButton("Müsteri Kredisini Onayla/Reddet");
        krediOnaylaReddetButton.addActionListener(this);
        mainMenuPanel.add(krediOnaylaReddetButton);

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
        if (e.getSource() == bankaciEkleButton) {
            // Open the bankaci ekle window
            BankaciEkleWindow bankaciEkleWindow = new BankaciEkleWindow();
            bankaciEkleWindow.setVisible(true);
        } else if (e.getSource() == bankaciDuzenleButton) {
            // Open the bankaci duzenle window
            BankaciDuzenleWindow bankaciDuzenleWindow = new BankaciDuzenleWindow();
            bankaciDuzenleWindow.setVisible(true);
        } else if (e.getSource() == bankaciSilButton) {
            // Open the bankaci sil window
            BankaciSilWindow bankaciSilWindow = new BankaciSilWindow();
            bankaciSilWindow.setVisible(true);
        } else if (e.getSource() == krediOnaylaReddetButton) {
            // Open the kredi onayla/reddet window
            KrediOnaylaReddetWindow krediOnaylaReddetWindow = new KrediOnaylaReddetWindow();
            krediOnaylaReddetWindow.setVisible(true);
        } else if (e.getSource() == logoutButton) {
            // Close the main menu and open the login window
            setVisible(false);
            MenuGUI login = new MenuGUI();
            login.setVisible(true);
        }
    }

}