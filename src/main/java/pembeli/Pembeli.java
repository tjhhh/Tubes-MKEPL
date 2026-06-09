package pembeli;

import com.method.main.Pengguna;
import penjual.Produk;
import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli extends Pengguna {
    private static ArrayList<Pembeli> daftarPembeli = new ArrayList<>(
        java.util.Arrays.asList(new Pembeli("Dhea Sri Noor Septianiz", "dhea@gmail.com", "dhea123", "081234567891"))
    );

    private final ArrayList<Produk> produkYangSudahDibeli = new ArrayList<>();
    private final ArrayList<String> produkYangSudahDiberiRating = new ArrayList<>();

    public Pembeli(String nama, String email, String password, String nomorTelepon) {
    super(nama, email, password, nomorTelepon);
    
    Produk.initializeDaftarProduk(); 
    ArrayList<Produk> produkRahmah = Produk.getDaftarProduk().get("Rahmah");
        if (produkRahmah != null) {
            for (Produk produk : produkRahmah) {
                if (produk.getNama().equals("Laptop ABC")) {
                    produkYangSudahDibeli.add(produk);
                    break;
                }
            }
        }
    }

    public static Pembeli cariPembeli(String email, String password) {
        for (Pembeli pembeli : daftarPembeli) {
            if (pembeli.getEmail().equals(email) && pembeli.getPassword().equals(password)) {
                return pembeli;
            }
        }
        return null;
    }

    public static void loginPembeli(Scanner scan) {
        while (true) {
            com.method.main.ConsoleUI.println("================================= Login Pembeli ==============================");
            String[] credentials = Pengguna.promptLogin(scan, "pembeli");
            if (credentials.length == 0) break;

            Pembeli pembeli = cariPembeli(credentials[0], credentials[1]);
            if (pembeli != null) {
                com.method.main.ConsoleUI.println("Login berhasil. Selamat datang, " + pembeli.getNama() + "!");
                MenuPembeli menu = new MenuPembeli(pembeli);
                menu.aksi(scan);
            } else {
                com.method.main.ConsoleUI.println("Login gagal. Email atau password salah. Coba lagi.");
            }
        }
    }

    public void tampilkanProdukSudahDibeli() {
        if (produkYangSudahDibeli.isEmpty()) {
            com.method.main.ConsoleUI.println("Anda belum membeli produk apapun.");
        } else {
            com.method.main.ConsoleUI.println("Produk yang sudah dibeli:");
            for (Produk produk : produkYangSudahDibeli) {
                produk.tampilkanInfo();
            }
        }
    }

    public void berikanRating(Scanner scanner) {
        com.method.main.ConsoleUI.print("Masukkan nama produk yang ingin diberi rating: ");
        String namaProduk = scanner.nextLine();

        Produk produkDitemukan = null;
        for (Produk produk : produkYangSudahDibeli) {
            if (produk.getNama().equalsIgnoreCase(namaProduk)) {
                produkDitemukan = produk;
                break;
            }
        }

        if (produkDitemukan != null) {
            com.method.main.ConsoleUI.print("Berikan rating (1-5): ");
            int ratingBintang = scanner.nextInt();
            scanner.nextLine();

            if (ratingBintang >= 1 && ratingBintang <= 5) {
                com.method.main.ConsoleUI.print("Berikan komentar: ");
                String komentarText = scanner.nextLine();

                Komentar komentar = new Komentar(komentarText);
                Rating rating = new Rating(produkDitemukan.getNama(), this.getNama(), "2025-01-01", ratingBintang);
                rating.tambahKomentar(komentar);
                Rating.getDaftarRating().add(rating);

                produkYangSudahDiberiRating.add(produkDitemukan.getNama());
                com.method.main.ConsoleUI.println("Rating berhasil diberikan untuk " + produkDitemukan.getNama());
            } else {
                com.method.main.ConsoleUI.println("Rating harus antara 1 sampai 5.");
            }
        } else {
            com.method.main.ConsoleUI.println("Produk " + namaProduk + " tidak ditemukan dalam daftar produk yang sudah dibeli.");
        }
    }


    public void tampilkanProdukDiberiRating() {
        if (produkYangSudahDiberiRating.isEmpty()) {
            com.method.main.ConsoleUI.println("Belum ada produk yang diberi rating.");
        } else {
            com.method.main.ConsoleUI.println("Produk yang sudah diberi rating:");
            for (Rating rating : Rating.getDaftarRating()) {
                if (rating.getPengguna().equals(this.getNama())) {
                    com.method.main.ConsoleUI.println("Produk: " + rating.getNamaProduk());
                    com.method.main.ConsoleUI.println("Tanggal Ulasan: " + rating.getTanggalUlasan());
                    com.method.main.ConsoleUI.println("Rating: " + rating.getRatingBintang() + " bintang");
                    com.method.main.ConsoleUI.print("Komentar: ");
                    for (Komentar komentar : rating.getDaftarKomentar()) {
                        com.method.main.ConsoleUI.println(komentar.getKomentarText());
                    }
                    com.method.main.ConsoleUI.println("------------------------------------------------------------------------------");
                }
            }
        }
    }

    @Override
    public void jenisPengguna() {
        com.method.main.ConsoleUI.println("=================================== Pembeli ==================================");
        super.tampilkanProfil();
    }
}
