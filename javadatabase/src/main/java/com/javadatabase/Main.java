package com.javadatabase;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws SQLException {

        // Veritabanı bağlantısı için bir nesne oluşturun
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-project", "root", "3755");

        // Sorgu için bir nesne oluşturun
        Statement statement = conn.createStatement();

        // Sorguyu çalıştırın ve sonuçları alın
        ResultSet resultSet = statement.executeQuery("SELECT * FROM app_accounts");

        // Sonuçları ekrana yazdırın
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        // Bağlantıyı kapatın
        conn.close();

        MenuGUI gui = new MenuGUI();
        gui.setVisible(true);
    }
}