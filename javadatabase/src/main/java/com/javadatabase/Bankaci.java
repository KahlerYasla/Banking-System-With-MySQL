package com.javadatabase;

import java.util.ArrayList;

public class Bankaci implements Kisi {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    public String kullaniciAdi;
    public String sifre;
    public String bankaciId;
    public String correspondingBankaMuduruId;
    public BankaMuduru correspondingBankaMuduru;
    public ArrayList<Musteri> musteriler = new ArrayList<Musteri>();

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Bankaci(String kullaniciAdi, String sifre, String bankaciId, String correspondingBankaMuduruId,
            BankaMuduru correspondingBankaMuduru, ArrayList<Musteri> musteriler, boolean create) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.bankaciId = bankaciId;
        this.correspondingBankaMuduruId = correspondingBankaMuduruId;
        this.correspondingBankaMuduru = correspondingBankaMuduru;
        this.musteriler = musteriler;

        if (create) {
            // Berkay: Database'e kaydet
        }
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

    public BankaMuduru getCorrespondingBankaMuduru() {
        return this.correspondingBankaMuduru;
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

}
