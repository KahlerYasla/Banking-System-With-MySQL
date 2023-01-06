package com.javadatabase;

public interface Kisi {

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public void setKullaniciAdi(String kullaniciAdi);

    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    public String getKullaniciAdi();

    public void setSifre(String sifre);

    public String getSifre();

    // Kullanıcı adı ve şifre doğrulaması için bir metod oluşturun
    public boolean girisYap(String sifre);

    // Kullanıcı adı ve şifre doğrulaması için bir metod oluşturun
    public void checkLoginCredentials(String userName, String sifre);

}