package penjual;

import java.util.Scanner;
import java.util.ArrayList;
import pembeli.Komentar;
import pembeli.Rating;

public class LaporUlasan {
    private final String namaProduk;
    private final String namaPengguna;
    private final String komentar;
    private static final ArrayList<LaporUlasan> ulasanDilanggar = new ArrayList<>();

    public LaporUlasan(String namaProduk, String namaPengguna, String komentar) {
        this.namaProduk = namaProduk;
        this.namaPengguna = namaPengguna;
        this.komentar = komentar;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getKomentar() {
        return komentar;
    }

    public static ArrayList<LaporUlasan> getUlasanDilanggar() {
        return ulasanDilanggar;
    }

    public static void tampilkanLaporan() {
        if (getUlasanDilanggar().isEmpty()) {
            com.method.main.ConsoleUI.println("Tidak ada ulasan yang dilaporkan.");
        } else {
            com.method.main.ConsoleUI.println("Daftar Ulasan yang Dilaporkan:");
            for (LaporUlasan ulasan : ulasanDilanggar) {
                com.method.main.ConsoleUI.println("- Produk: " + ulasan.getNamaProduk());
                com.method.main.ConsoleUI.println("  Pengguna: " + ulasan.getNamaPengguna());
                com.method.main.ConsoleUI.println("  Ulasan: " + ulasan.getKomentar());
                com.method.main.ConsoleUI.println();
            }
        }
    }

    public static void pilihDanLaporUlasan(Scanner scanner) {
        Rating ratingDipilih = Rating.cariDanTampilkanRating(scanner, "dilaporkan");
        if (ratingDipilih == null) return;

        com.method.main.ConsoleUI.print("\nApakah Anda ingin melaporkan ulasan ini? (ya/tidak): ");
        String konfirmasi = scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("ya")) {
            for (Komentar komentar : ratingDipilih.getDaftarKomentar()) {
                ulasanDilanggar.add(new LaporUlasan(ratingDipilih.getNamaProduk(), ratingDipilih.getPengguna(), komentar.getKomentarText()));
            }
            com.method.main.ConsoleUI.println("Ulasan untuk produk \"" + ratingDipilih.getNamaProduk() + "\" oleh pengguna \"" + ratingDipilih.getPengguna() + "\" telah dilaporkan.");
        } else {
            com.method.main.ConsoleUI.println("Ulasan tidak dilaporkan.");
        }
    }
}
