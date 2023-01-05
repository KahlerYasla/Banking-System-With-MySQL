package com.javadatabase;

import com.javadatabase.Bankaci;

public class BankaMuduru {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    private String kullaniciAdi;
    private String sifre;

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public BankaMuduru(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    // Kullanıcı adı ve şifre doğrulaması için bir metod oluşturun
    public boolean girisYap(String kullaniciAdi, String sifre) {
        if (this.kullaniciAdi.equals(kullaniciAdi) && this.sifre.equals(sifre)) {
            return true;
        }
        return false;
    }

    // Banka müdürünün yetkilerini kullanabileceği diğer metodları da bu sınıf
    // içinde oluşturabilirsiniz
    // Örneğin, yeni bankacı ekleme metodu:
    public void bankaciEkle(String bankaciAdi, String bankaciSifre) {
        // Yeni bankacı nesnesi oluşturun ve veritabanına ekleyin
        Bankaci yeniBankaci = new Bankaci(bankaciAdi, bankaciSifre);
        // Veritabanına ekleme işlemlerini gerçekleştirin
    }
}
