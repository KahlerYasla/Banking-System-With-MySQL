package com.javadatabase;

public class Bankaci {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    private String kullaniciAdi;
    private String sifre;

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Bankaci(String kullaniciAdi, String sifre) {
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

    // Bankacının yetkilerini kullanabileceği diğer metodları da bu sınıf içinde
    // oluşturabilirsiniz
    // Örneğin, müşteriye yeni banka hesabı açma metodu:
    public void hesapAc(String musteriAdi, String musteriSoyadi, long tcKimlikNo) {
        // Yeni hesap nesnesi oluşturun ve veritabanına ekleyin
        Hesap yeniHesap = new Hesap(musteriAdi, musteriSoyadi, tcKimlikNo);

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
