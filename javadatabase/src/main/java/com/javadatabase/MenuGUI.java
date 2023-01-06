package com.javadatabase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MenuGUI extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton exitButton;

    public MenuGUI() {
        // Set up the frame
        setTitle("Banka Otomasyonu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the login panel
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.setBackground(Color.DARK_GRAY);
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        usernameLabel = new JLabel("Kullanici adi:");
        usernameLabel.setForeground(Color.WHITE);
        loginPanel.add(usernameLabel);
        usernameField = new JTextField();
        loginPanel.add(usernameField);
        passwordLabel = new JLabel("Sifre:");
        passwordLabel.setForeground(Color.WHITE);
        loginPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);
        loginButton = new JButton("Giris Yap");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);
        exitButton = new JButton("Cikis");
        exitButton.addActionListener(this);
        loginPanel.add(exitButton);

        // Add the login panel and background image to the frame
        add(loginPanel, BorderLayout.CENTER);

        // Show the frame
        setVisible(true);
    }

    private int checkLoginCredentials(String username, char[] password) {
        int result = 0;
        //uygulamaHesaplari tablosundan kullanici adi ve sifre kontrolu yapilacak
        //kullanici adi bulunan satirdaki sifre ile girilen sifre karsilastirilacak
        //eger aynıysa ve türü bankaMüdürü ise 1, bankaÇalışanı ise 2, bankaMüşterisi ise 3 döndürülecek 
        //eger kullanici adi veya sifre yanlis ise 0 döndürülecek
        return result=2;
    }


    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == loginButton) {
            // Get the username and password from the text fields
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Perform the login process here (e.g. check the username and password against
            // a database)
            int loginIndex = checkLoginCredentials(username, password);

            if (loginIndex!=0) {
                // If the login is successful, display the main menu
                JOptionPane.showMessageDialog(this, "Giris basarili. Ilgili menuye yonlendiriliyorsunuz.", "Bilgi",
                        JOptionPane.INFORMATION_MESSAGE);
                // Close the login window
                setVisible(false);
                
                switch(loginIndex){
                    case 1:
                        BankaMuduruMenu menuBankaci = new BankaMuduruMenu();
                        menuBankaci.setVisible(true);
                        break;
                    case 2:
                        BankaCalisanMenu menuCalisan = new BankaCalisanMenu();
                        menuCalisan.setVisible(true);
                        break;
                    case 3:
                        BankaMusteriMenu menuMusteri = new BankaMusteriMenu();
                        menuMusteri.setVisible(true);
                        break;
                }

            } else {
                // If the login is unsuccessful, display an error message
                JOptionPane.showMessageDialog(this, "Giris basarisiz. Kullanici adi veya sifre yanlis.", "Hata",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == exitButton) {
            // Exit the application
            System.exit(0);
        }
    }

}
