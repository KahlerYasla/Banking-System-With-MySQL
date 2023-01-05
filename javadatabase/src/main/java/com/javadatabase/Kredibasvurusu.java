package com.javadatabase;

public class Kredibasvurusu {
    int durum; // 0: bekliyor, 1: onaylandı, 2: reddedildi
    String musteriId; // müşteri kimliği
    String uniqueHesapId; // hesap kimliği
    String uniqueKrediID; // kredi kimliği
    String miktar; // kredi miktarı
    Hesap hesap; // krediye bağlı hesap

    public Kredibasvurusu(String musteriId, String uniqueHesapId, String uniqueKrediID, String miktar, Hesap hesap) {
        durum = 0;
        this.musteriId = musteriId;
        this.uniqueHesapId = uniqueHesapId;
        this.uniqueKrediID = uniqueKrediID;
        this.miktar = miktar;
        this.hesap = hesap;
    }

    public int getDurum() {
        return this.durum;
    }

    public String getMusteriId() {
        return this.musteriId;
    }

    public String getUniqueHesapId() {
        return this.uniqueHesapId;
    }
    
    public String getUniqueKrediID() {
        return this.uniqueKrediID;
    }

    public String getMiktar() {
        return this.miktar;
    }

    public Hesap getHesap() {
        return this.hesap;
    }

    public void approveCredit() {
        durum = 1;
        hesap.deposit(miktar);
    }

    public void rejectCredit() {
        durum = 2;
    }

}
