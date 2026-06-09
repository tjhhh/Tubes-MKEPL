package penjual;

import pembeli.Rating;
import pembeli.Komentar;
import java.util.Scanner;

public class BalasUlasan {
    public static void balasUlasan(Scanner scanner) {
        Produk.tampilkanSemuaProduk();

        com.method.main.ConsoleUI.print("Masukkan nama produk yang ulasannya ingin dibalas: ");
        String namaProduk = scanner.nextLine();

        com.method.main.ConsoleUI.print("Masukkan nama pengguna yang ulasannya ingin dibalas: ");
        String namaPengguna = scanner.nextLine();

        boolean ulasanDitemukan = false;
        Rating ratingDipilih = null;

        for (Rating rating : Rating.getDaftarRating()) {
            if (rating.getNamaProduk().equalsIgnoreCase(namaProduk) &&
                rating.getPengguna().equalsIgnoreCase(namaPengguna)) {
                ulasanDitemukan = true;
                ratingDipilih = rating;
                break;
            }
        }

        if (!ulasanDitemukan) {
            com.method.main.ConsoleUI.println("Ulasan untuk produk \"" + namaProduk + "\" dari pengguna \"" + namaPengguna + "\" tidak ditemukan!");
            return;
        }

        com.method.main.ConsoleUI.println("\nUlasan dan Rating");
        com.method.main.ConsoleUI.println("Pengguna       : " + ratingDipilih.getPengguna());
        com.method.main.ConsoleUI.println("Tanggal Ulasan : " + ratingDipilih.getTanggalUlasan());
        com.method.main.ConsoleUI.println("Rating         : " + ratingDipilih.getRatingBintang() + " bintang");
        com.method.main.ConsoleUI.println("Komentar       :");
        for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
            com.method.main.ConsoleUI.println("  - " + komentar.getKomentarText());
        }

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
