package com.javadatabase;

public class Musteri {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    private String kullaniciAdi;
    private String sifre;

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Musteri(String kullaniciAdi, String sifre) {
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

    // Müşterinin yetkilerini kullanabileceği diğer metodları da bu sınıf içinde
    // oluşturabilirsiniz
    // Örneğin, kendisine ait banka hesaplarını ve bakiye bilgilerini görüntüleme
    // metodu:
    public void hesapBilgileriniGoruntule() {
        // Müşterinin hesap bilgilerini veritabanından çekin ve ekrana yazdırın
    }
}