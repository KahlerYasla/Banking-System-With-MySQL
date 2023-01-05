public class Main {

    /*
     * public static void main(String[] args) {
     * 
     * // Menü nesnesini oluş1turun
     * Menu menu = new Menu();
     * 
     * while (menu.getSecim() != 4) {
     * // Menüyü ekrana yazdırın
     * menu.menuyuYazdir();
     * 
     * // Menüden seçim yapın
     * menu.secimYap();
     * 
     * // Seçime göre işlemleri gerçekleştirin
     * menu.islemleriYap(menu.getSecim());
     * }
     * }
     */

    public static void main(String[] args) {
        MenuGUI gui = new MenuGUI();
        gui.setVisible(true);
    }
}
