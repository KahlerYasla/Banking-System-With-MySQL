package com.javadatabase;

public interface Kisi {
    // Kullanıcı adı ve şifre özelliklerini tanımlayın
    public String getKullaniciAdi();

    public String getSifre();

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public void setKullaniciAdi(String kullaniciAdi);

    public void setSifre(String sifre);

    // Kullanıcı adı ve şifre doğrulaması için bir metod oluşturun
    public boolean girisYap(String kullaniciAdi, String sifre);

}
