public class Main {

    public void main(String[] args) {

        // Menü nesnesini oluşturun
        Menu menu = new Menu();

        while (menu.getSecim() != 4) {
            // Menüyü ekrana yazdırın
            menu.menuyuYazdir();

            // Menüden seçim yapın
            menu.secimYap();

            // Seçime göre işlemleri gerçekleştirin
            menu.islemleriYap(menu.getSecim());
        }
    }
}
