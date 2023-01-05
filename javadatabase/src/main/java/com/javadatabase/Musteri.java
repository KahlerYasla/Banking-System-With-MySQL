package com.javadatabase;

import java.util.ArrayList;
import java.util.Random;

public class Musteri {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    public String kullaniciAdi;
    public String sifre;
    public String musteriId;
    public String correspondingBankaciId;
    public Bankaci correspondingBankaci;
    public ArrayList<Hesap> hesaplar = new ArrayList<Hesap>();

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Musteri(String kullaniciAdi, String sifre, String musteriId, String correspondingBankaciId,
            Bankaci correspondingBankaci, ArrayList<Hesap> hesaplar, boolean create) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.musteriId = musteriId;
        this.correspondingBankaciId = correspondingBankaciId;
        this.correspondingBankaci = correspondingBankaci;
        this.hesaplar = hesaplar;

        if (create) {
            // Berkay: Database'e kaydet
        }
    }

    public String getKullaniciAdi() {
        return this.kullaniciAdi;
    };

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;

        // Berkay: Database'de güncelle

    };

    public String getSifre() {
        return this.sifre;
    };

    public void setSifre(String sifre) {
        this.sifre = sifre;

        // Berkay: Database'de güncelle

    };

    public boolean girisYap(String sifre) {
        if (this.sifre.equals(sifre)) {
            return true;
        }
        return false;
    }

    public Bankaci getCorrespondingBankaci() {
        return this.correspondingBankaci;
    }

    public void hesapAc() {

        Random random = new Random();

        String uniqueHesapId = String.valueOf(random.nextInt(1000000000));

        while (true) {
            boolean unique = true;
            for (Hesap hesap : this.hesaplar) {
                if (hesap.getUniqueHesapID().equals(uniqueHesapId)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                break;
            }
            uniqueHesapId = String.valueOf(random.nextInt(1000000000));

        }

        Hesap hesap = new Hesap(this.musteriId, uniqueHesapId);

        String fullHesapId = hesap.getFullHesapID();

        // berkay: fullHesapId Primary Key olmak üzere database'e kaydet
        // başarabilirsen weak entity uniqueHesapId ile musteriId'yi birleştirerek
        // hazırla

        this.hesaplar.add(hesap);
    }

    public void hesapKapat(String uniqueHesapId) {
        for (Hesap hesap : this.hesaplar) {
            if (hesap.getUniqueHesapID().equals(uniqueHesapId)) {
                this.hesaplar.remove(hesap);
                // berkay: database'den sil
                break;
            }
        }
    }

    public void paraYatir(String uniqueHesapId, String miktar) {
        for (Hesap hesap : this.hesaplar) {
            if (hesap.getUniqueHesapID().equals(uniqueHesapId)) {
                hesap.deposit(miktar);
                // berkay: database'de güncelle
                break;
            }
        }
    }

    public void paraCek(String uniqueHesapId, String miktar) {
        for (Hesap hesap : this.hesaplar) {
            if (hesap.getUniqueHesapID().equals(uniqueHesapId)) {
                hesap.withdraw(miktar);
                // berkay: database'de güncelle
                break;
            }
        }
    }

    public void paraTransfer(String uniqueHesapIdFrom, String miktar, String uniqueHesapIdTo) {
        for (Hesap hesap : this.hesaplar) {
            boolean hesapFromExists = false;
            boolean hesapToExists = false;

            Hesap hesapFrom = null;
            Hesap hesapTo = null;

            if (hesap.getUniqueHesapID().equals(uniqueHesapIdFrom)) {
                hesapFromExists = true;
                hesapFrom = hesap;
            }
            if (hesap.getUniqueHesapID().equals(uniqueHesapIdTo)) {
                hesapToExists = true;
                hesapTo = hesap;
            }

            if (hesapFromExists && hesapToExists) {
                hesapFrom.withdraw(miktar);
                hesapTo.deposit(miktar);
                // berkay: database'de güncelle
            }
        }
    }

    public void krediBasvuru(String uniqueHesapId, String miktar) {
        for (Hesap hesap : this.hesaplar) {
            if (hesap.getUniqueHesapID().equals(uniqueHesapId)) {

                this.getCorrespondingBankaci().getCorrespondingBankaMuduru().yeniKrediBasvurusu(this.musteriId,
                        hesap.getUniqueHesapID(), miktar, hesap);

                // berkay: database'de güncelle
                break;
            }
        }
    }

}