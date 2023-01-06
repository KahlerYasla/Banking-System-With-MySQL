package com.javadatabase;

import java.util.ArrayList;
import java.util.Random;

public class BankaMuduru implements Kisi {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    public String kullaniciAdi;
    public String sifre;
    public String bankaMuduruId;
    public ArrayList<Bankaci> bankacilar = new ArrayList<Bankaci>();
    public ArrayList<Kredibasvurusu> kredibasvurulari = new ArrayList<Kredibasvurusu>();

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public BankaMuduru(String kullaniciAdi, String sifre, ArrayList<Kredibasvurusu> kredibasvurulari, ArrayList<Bankaci> bankacilar, boolean create) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.kredibasvurulari = kredibasvurulari;

        if (create) {
            // Berkay: Database'e kaydet
        }
        
    }

    public String getKullaniciAdi() {
        return this.kullaniciAdi;
    };

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    };

    public String getSifre() {
        return this.sifre;
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

    public void yeniBankaciEkle() {
        Random random = new Random();
        String bankaciId = String.valueOf(random.nextInt(1000000000));

        while (true) {
            boolean unique = true;
            for (Bankaci bankaci : this.bankacilar) {
                if (bankaci.bankaciId.equals(bankaciId)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                break;
            }
            bankaciId = String.valueOf(random.nextInt(1000000000));

        }
    }

    public void bankaciSil(String bankaciId) {
        for (Bankaci bankaci : this.bankacilar) {
            if (bankaci.bankaciId.equals(bankaciId)) {
                bankacilar.remove(bankaci);
                break;
            }
        }
    }

    public void bankaciKullaniciAdiDegistir(String bankaciId, String yeniKullaniciAdi) {
        for (Bankaci bankaci : this.bankacilar) {
            if (bankaci.bankaciId.equals(bankaciId)) {
                bankaci.kullaniciAdi = yeniKullaniciAdi;
                break;
            }
        }
    }

    public void yeniKrediBasvurusu(String musteriId, String uniqueHesapID, String miktar, Hesap hesap) {

        Random rand = new Random();

        String uniqueKrediId = musteriId + uniqueHesapID + String.valueOf(rand.nextInt(1000000000));

        while (true) {
            boolean unique = true;
            for (Kredibasvurusu kredibasvurusu : this.kredibasvurulari) {
                if (kredibasvurusu.getUniqueKrediID().equals(uniqueKrediId)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                break;
            }
            uniqueKrediId = musteriId + uniqueHesapID + String.valueOf(rand.nextInt(1000000000));

        }

        Kredibasvurusu kredibasvurusu = new Kredibasvurusu(musteriId, uniqueHesapID, uniqueKrediId, miktar, hesap);
        this.kredibasvurulari.add(kredibasvurusu);
        // Berkay: Database'e kaydet
    }

    public void krediBasvurusunuOnayla(String kredibasvurusuId) {
        for (Kredibasvurusu kredibasvurusu : this.kredibasvurulari) {
            if (kredibasvurusu.getUniqueKrediID().equals(kredibasvurusuId)) {
                kredibasvurusu.approveCredit();
                // Berkay: Database'de güncelle
                break;
            }
        }
    }

    public void krediBasvurusunuReddet(String kredibasvurusuId) {
        for (Kredibasvurusu kredibasvurusu : this.kredibasvurulari) {
            if (kredibasvurusu.getUniqueKrediID().equals(kredibasvurusuId)) {
                kredibasvurusu.rejectCredit();
                // Berkay: Database'de güncelle
                break;
            }
        }
    }

    public void krediBasvurusunuSil(String kredibasvurusuId) {
        for (Kredibasvurusu kredibasvurusu : this.kredibasvurulari) {
            if (kredibasvurusu.getUniqueKrediID().equals(kredibasvurusuId)) {
                this.kredibasvurulari.remove(kredibasvurusu);
                // Berkay: Database'den sil
                break;
            }
        }
    }

    public int getKrediBasvuruDurumu(String kredibasvurusuId) {
        for (Kredibasvurusu kredibasvurusu : this.kredibasvurulari) {
            if (kredibasvurusu.getUniqueKrediID().equals(kredibasvurusuId)) {
                return kredibasvurusu.getDurum();
            }
        }
        return -1;
    }

}
