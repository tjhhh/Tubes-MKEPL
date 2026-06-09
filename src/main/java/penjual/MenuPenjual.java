package penjual;

import com.method.main.Menu;
import java.util.Scanner;

public class MenuPenjual implements Menu {
    private Penjual penjual;
    private Produk produk;
    public MenuPenjual(Penjual penjual) {
        this.penjual = penjual;
        this.produk = new Produk();
    }
    
    public MenuPenjual(){
    }
    
    @Override
    public void tampilkanMenu() {
        com.method.main.ConsoleUI.println("============================== Menu Penjual ==================================");
        com.method.main.ConsoleUI.println("1. Daftar Produk");
        com.method.main.ConsoleUI.println("2. Profil");
        com.method.main.ConsoleUI.println("3. Keluar");
    }

    @Override
    public void aksi(Scanner scanner) {
        
        while (true) {
            tampilkanMenu();
            com.method.main.ConsoleUI.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    produk.menuProduk(scanner);
                    break;
                case 2:
                    penjual.jenisPengguna();
                    break;
                case 3:
                    com.method.main.ConsoleUI.println("Keluar dari menu penjual.");
                    return;
                default:
                    com.method.main.ConsoleUI.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}