package com.javadatabase;

import java.util.Scanner;

import com.javadatabase.Bankaci;
import com.javadatabase.Musteri;

public class Menu {

    private int secim;

    public int getSecim() {
        return secim;
    }

    public void setSecim(int secim) {
        this.secim = secim;
    }

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Menu() {
    }

    // Menüyü ekrana yazdırmak için bir metod oluşturun
    public void menuyuYazdir() {
        System.out.println("1. Banka muduru girisi");
        System.out.println("2. Bankaci girisi");
        System.out.println("3. Musteri girisi");
        System.out.println("4. Cikis");
    }

    // Menüden seçim yapmak için bir metod oluşturun
    public void secimYap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seciminiz: ");
        this.secim = scanner.nextInt();
    }

    // Seçime göre işlemleri gerçekleştirmek için bir metod oluşturun
    public void islemleriYap(int secim) {
        switch (secim) {
            case 1: {
                // Banka müdürü girişi
                // Banka müdürü nesnesini oluşturun
                BankaMuduru bankaMuduru = new BankaMuduru("admin", "admin");

                // Kullanıcı adı ve şifre doğrulaması
                if (bankaMuduru.girisYap("admin", "admin")) {
                    // Kullanıcı adı ve şifre doğruysa, bankacı ekleme işlemini gerçekleştirin
                    bankaMuduru.bankaciEkle("bankaci", "bankaci");
                } else {
                    // Kullanıcı adı ve şifre yanlışsa, hata mesajı yazdırın
                    System.out.println("Kullanici adi veya sifre yanlis!");
                }
                break;
            }
            case 2: {
                // Bankacı girişi
                // Bankacı nesnesini oluşturun
                Bankaci bankaci = new Bankaci("bankaci", "bankaci");

                // Kullanıcı adı ve şifre doğrulaması
                if (bankaci.girisYap("bankaci", "bankaci")) {
                    // Kullanıcı adı ve şifre doğruysa, müşteriye yeni banka hesabı açma
                    // işlemini gerçekleştirin
                    bankaci.hesapAc("musteri", "musteri", 12345678910L);
                } else {
                    // Kullanıcı adı ve şifre yanlışsa, hata mesajı yazdırın
                    System.out.println("Kullanici adi veya sifre yanlis!");
                }
                break;
            }
            case 3: {
                // Müşteri girişi
                // Müşteri nesnesini oluşturun
                Musteri musteri = new Musteri("musteri", "musteri");

                // Kullanıcı adı ve şifre doğrulaması
                if (musteri.girisYap("musteri", "musteri")) {
                    // Kullanıcı adı ve şifre doğruysa, müşterinin hesap bilgilerini görüntüleme
                    // işlemini gerçekleştirin
                    musteri.hesapBilgileriniGoruntule();
                } else {
                    // Kullanıcı adı ve şifre yanlışsa, hata mesajı yazdırın
                    System.out.println("Kullanici adi veya sifre yanlis!");
                }
                break;
            }
            case 4: {
                // Çıkış
                System.out.println("Cikis yapiliyor...");
                break;
            }
            default: {
                System.out.println("Hatali secim!");
                break;
            }
        }
    }

}