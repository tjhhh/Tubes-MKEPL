package moderator;

import com.method.main.Menu;
import penjual.Produk;
import java.util.Scanner;
import penjual.LaporUlasan;

public class MenuModerator implements Menu {
    private final Moderator moderator;

    public MenuModerator(Moderator moderator) {
        this.moderator = moderator;
    }

    @Override
    public void tampilkanMenu() {
        com.method.main.ConsoleUI.println("============================= Menu Moderator =================================");
        com.method.main.ConsoleUI.println("1. Lihat laporan");
        com.method.main.ConsoleUI.println("2. Hapus Ulasan");
        com.method.main.ConsoleUI.println("3. Lihat Riwayat Moderasi");
        com.method.main.ConsoleUI.println("4. Lihat Daftar Produk");
        com.method.main.ConsoleUI.println("5. Profil");
        com.method.main.ConsoleUI.println("6. Keluar");
    }

    @Override
    public void aksi(Scanner scanner) {
        int pilihan;

        while (true) {
            tampilkanMenu();
            com.method.main.ConsoleUI.print("Pilih aksi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    lihatLaporan();
                    break;
                case 2:
                    HapusUlasan.hapusUlasan(moderator, scanner);
                    break;
                case 3:
                    RiwayatModerasi.tampilkanRiwayat();
                    break;
                case 4:
                    Produk.tampilkanSemuaProduk();
                    break;
                case 5:
                    moderator.jenisPengguna();
                    break;
                case 6:
                    com.method.main.ConsoleUI.println("Keluar dari menu moderator.");
                    return;
                default:
                    com.method.main.ConsoleUI.println("Pilihan tidak valid.");
            }
        }
    }

    public void lihatProduk() {
        com.method.main.ConsoleUI.println("============================= Daftar Produk =================================");
        Produk.tampilkanSemuaProduk();
    }
    
    public void lihatLaporan() {
        com.method.main.ConsoleUI.println("============================= Daftar Laporan =================================");
        LaporUlasan.tampilkanLaporan();
    }
}