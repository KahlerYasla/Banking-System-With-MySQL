package com.javadatabase;

public class Bankaci implements Kisi {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    private String kullaniciAdi;
    private String sifre;

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Bankaci(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return this.kullaniciAdi;
    };

    public String getSifre() {
        return this.sifre;
    };

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    };

    public void setSifre(String sifre) {
        this.sifre = sifre;
    };

    // Kullanıcı adı ve şifre doğrulaması için bir metod oluşturun
    public boolean girisYap(String sifre) {
        if (this.sifre.equals(sifre)) {
            return true;
        }
        return false;
    }

    // Kullanıcı adı ve şifre doğrulaması için bir metod oluşturun
    public boolean girisYap(String kullaniciAdi, String sifre) {
        if (this.kullaniciAdi.equals(kullaniciAdi) && this.sifre.equals(sifre)) {
            return true;
        }
        return false;
    }

    public void paraYatir(long hesapNo, double miktar) {
        // Veritabanından hesapNo ile eşleşen hesabı getirin
        // Hesabın bakiyesini miktar kadar arttırın
    }

    public void paraCek(long hesapNo, double miktar) {
        // Veritabanından hesapNo ile eşleşen hesabı getirin
        // Hesabın bakiyesini miktar kadar azaltın
    }

    public void musteriBilgileriniGuncelle(long hesapNo, String musteriAdi, String musteriSoyadi, long tcKimlikNo) {
        // Veritabanından hesapNo ile eşleşen hesabı getirin
        // Hesabın müşteri bilgilerini güncelleyin
    }

    public void hesabiKapat(long hesapNo) {
        // Veritabanından hesapNo ile eşleşen hesabı getirin
        // Hesabı veritabanından silin
    }

    public void musteriEkle(String kullaniciAdi, String sifre, long tcKimlikNo) {
        // Yeni müşteri nesnesi oluşturun ve veritabanına ekleyin
        // Musteri yeniMusteri = new Musteri(musteriAdi, musteriSoyadi, tcKimlikNo);
        // Veritabanına ekleme işlemlerini gerçekleştirin
    }
}
