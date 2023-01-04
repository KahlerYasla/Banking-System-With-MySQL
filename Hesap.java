public class Hesap {
    // Müşteri bilgilerini tanımlayın
    private String musteriAdi;
    private String musteriSoyadi;
    private long tcKimlikNo;

    // Bu sınıfın nesnelerinin oluşturulması için bir yapıcı metod oluşturun
    public Hesap(String musteriAdi, String musteriSoyadi, long tcKimlikNo) {
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.tcKimlikNo = tcKimlikNo;
    }

    // Müşteri bilgilerini güncelleme metodu
    public void bilgileriGuncelle(String musteriAdi, String musteriSoyadi, long tcKimlikNo) {
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.tcKimlikNo = tcKimlikNo;
    }

    // Müşteri bilgilerini getirme metodu
    public String getMusteriAdi() {
        return this.musteriAdi;
    }

    public String getMusteriSoyadi() {
        return this.musteriSoyadi;
    }

    public long getTcKimlikNo() {
        return this.tcKimlikNo;
    }
}
