package pembeli;

import com.method.main.Menu;
import penjual.Produk;
import java.util.Scanner;

public class MenuPembeli implements Menu {
    private final Pembeli pembeli;

    public MenuPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    @Override
    public void tampilkanMenu() {
        com.method.main.ConsoleUI.println("============================== Menu Pembeli ==================================");
        com.method.main.ConsoleUI.println("1. Lihat Produk");
        com.method.main.ConsoleUI.println("2. Lihat Produk yang Sudah Dibeli");
        com.method.main.ConsoleUI.println("3. Berikan Rating Pada Produk yang Sudah Dibeli");
        com.method.main.ConsoleUI.println("4. Lihat Produk yang Sudah Diberi Rating");
        com.method.main.ConsoleUI.println("5. Profil");
        com.method.main.ConsoleUI.println("6. Keluar");
    }

    @Override
    public void aksi(Scanner scanner) {
        int pilihan;

        while (true) {
            tampilkanMenu();
            pilihan = com.method.main.ConsoleUI.getPilihan(scanner, "Pilih menu : ");

            switch (pilihan) {
                case 1:
                    Produk.tampilkanSemuaProduk();
                    break;
                case 2:
                    pembeli.tampilkanProdukSudahDibeli(); 
                    break;
                case 3:
                    pembeli.berikanRating(scanner); 
                    break;
                case 4:
                    pembeli.tampilkanProdukDiberiRating(); 
                    break;
                case 5:
                    pembeli.jenisPengguna(); 
                    break;
                case 6:
                    com.method.main.ConsoleUI.println("Kembali ke menu utama ...\n");
                    return; 
                default:
                    com.method.main.ConsoleUI.println("Pilihan tidak valid.");
            }
        }
    }
}
