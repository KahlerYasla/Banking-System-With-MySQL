package com.javadatabase;

import java.util.ArrayList;
import java.util.Random;

public class Bankaci implements Kisi {
    // Kullanici adi ve şifre özelliklerini tanimlayin
    public String kullaniciAdi;
    public String sifre;
    public String bankaciId;
    public String correspondingBankaMuduruId;
    public BankaMuduru correspondingBankaMuduru;
    public ArrayList<Musteri> musteriler = new ArrayList<Musteri>();

    // Bu sinifin nesnelerinin oluşturulmasi için bir yapici metod oluşturun
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

    public void checkLoginCredentials(String userName, String sifre){};

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

    public boolean girisYap(String sifre) {
        if (this.sifre.equals(sifre)) {
            return true;
        }
        return false;
    }

    public void createNewHesapForMusteri(String musteriId) {
        for (Musteri musteri : musteriler) {
            if (musteri.musteriId.equals(musteriId)) {
                musteri.hesapAc();
                break;
            }
        }
    }

    public void yeniMusteriEkle() {
        Random random = new Random();
        String musteriId = String.valueOf(random.nextInt(1000000000));

        while (true) {
            boolean unique = true;
            for (Bankaci bankaci : this.correspondingBankaMuduru.bankacilar) {
                for (Musteri musteri : bankaci.musteriler) {
                    if (musteri.musteriId.equals(musteriId)) {
                        unique = false;
                        break;
                    }
                }
            }
            if (unique) {
                break;
            }
            musteriId = String.valueOf(random.nextInt(1000000000));

        }
    }

    public void musteriSil(String musteriId) {
        for (Musteri musteri : musteriler) {
            if (musteri.musteriId.equals(musteriId)) {
                musteriler.remove(musteri);
                break;
            }
        }
    }

    public void musteriKullaniciAdiDegistir(String musteriId, String yeniKullaniciAdi) {
        for (Musteri musteri : musteriler) {
            if (musteri.musteriId.equals(musteriId)) {
                musteri.kullaniciAdi = yeniKullaniciAdi;
                break;
            }
        }
    }

    public void musteriHesabinaParaYatir(String musteriId, String uniqueHesapID, String paraMiktari) {
        for (Musteri musteri : musteriler) {
            if (musteri.musteriId.equals(musteriId)) {
                for (Hesap hesap : musteri.hesaplar) {
                    if (hesap.uniqueHesapID.equals(uniqueHesapID)) {
                        hesap.deposit(paraMiktari);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void musteriHesabindanParaCek(String musteriId, String uniqueHesapID, String paraMiktari) {
        for (Musteri musteri : musteriler) {
            if (musteri.musteriId.equals(musteriId)) {
                for (Hesap hesap : musteri.hesaplar) {
                    if (hesap.uniqueHesapID.equals(uniqueHesapID)) {
                        hesap.withdraw(paraMiktari);
                        break;
                    }
                }
                break;
            }
        }
    }

}
