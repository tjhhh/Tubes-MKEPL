package penjual;

import pembeli.Rating;
import pembeli.Komentar;
import java.util.Scanner;

public class BalasUlasan {

    private BalasUlasan() {
        throw new IllegalStateException("Utility class");
    }

    public static void balasUlasan(Scanner scanner) {
        Produk.tampilkanSemuaProduk();

        com.method.main.ConsoleUI.print("Masukkan nama produk yang ulasannya ingin dibalas: ");
        String namaProduk = scanner.nextLine();

        com.method.main.ConsoleUI.print("Masukkan nama pengguna yang ulasannya ingin dibalas: ");
        String namaPengguna = scanner.nextLine();

        Rating ratingDipilih = Rating.cariRating(namaProduk, namaPengguna);

        if (ratingDipilih == null) {
            com.method.main.ConsoleUI.println("Ulasan untuk produk \"" + namaProduk + "\" dari pengguna \"" + namaPengguna + "\" tidak ditemukan!");
            return;
        }

        ratingDipilih.tampilkanDetail();

        com.method.main.ConsoleUI.print("\nMasukkan balasan Anda untuk ulasan ini: ");
        String balasan = scanner.nextLine();

        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            komentar.tambahBalasan(balasan);
        }

        com.method.main.ConsoleUI.println("\nBalasan Anda telah ditambahkan untuk ulasan pengguna \"" + namaPengguna + "\":");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            com.method.main.ConsoleUI.println("  \"" + komentar.getKomentarText() + "\" -> \"" + balasan + "\"");
        }
    }
}
