package com.javadatabase;

public class Hesap {
    // Müşteri bilgilerini tanımlayın
    public String balance;
    public String uniqueHesapID;
    public String fullHesapID;

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Hesap(String musteriId, String uniqueHesapId) {
        balance = "0";
        this.uniqueHesapID = uniqueHesapId;
        this.fullHesapID = uniqueHesapId + musteriId;

    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getUniqueHesapID() {
        return this.uniqueHesapID;
    }

    public void setUniqueHesapID(String uniqueHesapID) {
        this.uniqueHesapID = uniqueHesapID;
    }

    public String getFullHesapID() {
        return this.fullHesapID;
    }

    public void setFullHesapID(String fullHesapID) {
        this.fullHesapID = fullHesapID;
    }

    public void withdraw(String amount) {
        balance = String.valueOf(Integer.parseInt(balance) - Integer.parseInt(amount));
    }

    public void deposit(String amount) {
        balance = String.valueOf(Integer.parseInt(balance) + Integer.parseInt(amount));
    }

}
