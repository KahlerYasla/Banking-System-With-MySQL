import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    private BankaMuduru bankaMuduru;
    private Bankaci bankaci;
    private Musteri musteri;

    public MenuGUI() {
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

        // Create the background image label
        JLabel backgroundImage = new JLabel(new ImageIcon("background.png"));

        // Add the login panel and background image to the frame
        add(loginPanel, BorderLayout.CENTER);
        add(backgroundImage, BorderLayout.PAGE_START);

        // Create the bank manager, banker, and customer objects
        bankaMuduru = new BankaMuduru("admin", "admin");
        bankaci = new Bankaci("bankaci", "bankaci");
        musteri = new Musteri("musteri", "musteri");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            if (username.equals("admin") && new String(password).equals("admin")) {
                // Bank manager login
                bankaMuduru.bankaciEkle("bankaci", "bankaci");
            } else if (username.equals("bankaci") && new String(password).equals("bankaci")) {
                // Banker login
                bankaci.hesapAc("musteri", "musteri", 12345678910L);
            } else if (username.equals("musteri") && new String(password).equals("musteri")) {
                // Customer login
                musteri.hesapBilgileriniGoruntule();
            } else {
                // Invalid username or password
                System.out.println("Kullanici adf veya şifre yanliş!");
            }
        } else if (e.getSource() == exitButton) {
            // Exit the program
            System.exit(0);
        }
    }
}