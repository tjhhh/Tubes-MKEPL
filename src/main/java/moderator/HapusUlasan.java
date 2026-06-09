package moderator;

import java.util.ArrayList;
import java.util.Map;
import penjual.Produk;
import java.util.Scanner;
import pembeli.Rating;

public class HapusUlasan {

    private HapusUlasan() {
        throw new IllegalStateException("Utility class");
    }

    public static void hapusUlasan(Moderator moderator, Scanner scanner) {
        Produk.initializeDaftarProduk();

        com.method.main.ConsoleUI.print("Masukan nama produk: ");
        String namaProduk = scanner.nextLine();

        if (!cekProdukAda(namaProduk)) {
            com.method.main.ConsoleUI.println("Nama produk tidak ditemukan!");
            return;
        }

        com.method.main.ConsoleUI.println("Produk dengan nama \"" + namaProduk + "\" ditemukan.");

        com.method.main.ConsoleUI.print("Masukkan nama pengguna yang memberi ulasan: ");
        String namaPengguna = scanner.nextLine();
        
        Rating targetRating = cariRating(namaProduk, namaPengguna);

        if (targetRating == null) {
            com.method.main.ConsoleUI.println("Nama pengguna tidak ditemukan!");
            return;
        }

        String isiUlasan = targetRating.toString();  

        RiwayatModerasi.tambahRiwayatHapusUlasan(namaProduk, namaPengguna, isiUlasan);

        Rating.hapusRating(namaProduk, namaPengguna);
        moderator.setJumlahUlasanDihapus(1);
        com.method.main.ConsoleUI.println("Ulasan oleh pengguna " + namaPengguna + " untuk produk " + namaProduk + " telah dihapus.");
    }

    private static boolean cekProdukAda(String namaProduk) {
        for (Map.Entry<String, ArrayList<Produk>> entry : Produk.getDaftarProduk().entrySet()) {
            for (Produk p : entry.getValue()) {
                if (namaProduk.equalsIgnoreCase(p.getNama())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Rating cariRating(String namaProduk, String namaPengguna) {
        for (Rating r : Rating.getDaftarRating()) {
            if (namaPengguna.equals(r.getPengguna()) && r.getNamaProduk().equalsIgnoreCase(namaProduk)) {
                return r;
            }
        }
        return null;
    }
}
