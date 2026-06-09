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

        Rating ratingDipilih = Rating.cariDanTampilkanRating(scanner, "dibalas");
        if (ratingDipilih == null) return;

        com.method.main.ConsoleUI.print("\nMasukkan balasan Anda untuk ulasan ini: ");
        String balasan = scanner.nextLine();

        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            komentar.tambahBalasan(balasan);
        }

        com.method.main.ConsoleUI.println("\nBalasan Anda telah ditambahkan untuk ulasan pengguna \"" + ratingDipilih.getPengguna() + "\":");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            com.method.main.ConsoleUI.println("  \"" + komentar.getKomentarText() + "\" -> \"" + balasan + "\"");
        }
    }
}
