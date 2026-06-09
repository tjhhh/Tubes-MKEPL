package pembeli;

import java.util.ArrayList;

import java.util.List;

public class Rating {
    private String namaProduk;
    private String pengguna;
    private String tanggalUlasan;
    private int ratingBintang;
    private List<Komentar> daftarKomentar;

    private static final String LBL_PENGGUNA = "Pengguna       : ";
    private static final String LBL_TANGGAL = "Tanggal Ulasan : ";
    private static final String LBL_RATING = "Rating         : ";
    private static final String LBL_KOMENTAR = "Komentar       :";

    private static final List<Rating> daftarRating = new ArrayList<>();

    static {
        Rating rating1 = new Rating("Laptop ABC", "Kroos", "2024-12-01", 5);
        rating1.tambahKomentar(Komentar.getDaftarKomentar().get(0));

        Rating rating2 = new Rating("Laptop ABC", "Thanos", "2024-12-02", 4);
        rating2.tambahKomentar(Komentar.getDaftarKomentar().get(1));

        Rating rating3 = new Rating("Headphone DEF", "Modric", "2024-12-03", 4);
        rating3.tambahKomentar(Komentar.getDaftarKomentar().get(2));

        Rating rating4 = new Rating("Headphone DEF", "Wanda", "2024-12-04", 5);
        rating4.tambahKomentar(Komentar.getDaftarKomentar().get(3));

        daftarRating.add(rating1);
        daftarRating.add(rating2);
        daftarRating.add(rating3);
        daftarRating.add(rating4);
    }

    public Rating(String namaProduk, String pengguna, String tanggalUlasan, int ratingBintang) {
        this.namaProduk = namaProduk;
        this.pengguna = pengguna;
        this.tanggalUlasan = tanggalUlasan;
        this.ratingBintang = ratingBintang;
        this.daftarKomentar = new ArrayList<>();
    }

    public void tambahKomentar(Komentar komentar) {
        this.daftarKomentar.add(komentar);
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public List<Komentar> getDaftarKomentar() {
        return daftarKomentar;
    }

    public String getPengguna() {
        return pengguna;
    }

    public String getTanggalUlasan() {
        return tanggalUlasan;
    }

    public int getRatingBintang() {
        return ratingBintang;
    }

    public static List<Rating> getDaftarRating() {
        return daftarRating;
    }

    private static void cetakSatuRating(Rating rating) {
        com.method.main.ConsoleUI.println(LBL_PENGGUNA + rating.getPengguna());
        com.method.main.ConsoleUI.println(LBL_TANGGAL + rating.getTanggalUlasan());
        com.method.main.ConsoleUI.println(LBL_RATING + rating.getRatingBintang() + " bintang");
        com.method.main.ConsoleUI.println(LBL_KOMENTAR);

        for (Komentar komentar : rating.getDaftarKomentar()) {
            com.method.main.ConsoleUI.println("  - " + komentar.getKomentarText());

            ArrayList<String> balasanList = komentar.getBalasan();
            if (!balasanList.isEmpty()) {
                com.method.main.ConsoleUI.println("    Balasan dari penjual:");
                for (String balasan : balasanList) {
                    com.method.main.ConsoleUI.println("      -> " + balasan);
                }
            }
        }
        com.method.main.ConsoleUI.println();
    }

    public static void tampilkanRating(String namaProduk) {
        List<Rating> daftarRating = Rating.getDaftarRating();

        boolean ditemukan = false;
        for (Rating rating : daftarRating) {
            if (rating.getNamaProduk().equals(namaProduk)) {
                ditemukan = true;
                cetakSatuRating(rating);
            }
        }

        if (!ditemukan) {
            com.method.main.ConsoleUI.println("Belum ada ulasan untuk produk ini.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(LBL_PENGGUNA).append(pengguna).append("\n")
              .append(LBL_TANGGAL).append(tanggalUlasan).append("\n")
              .append(LBL_RATING).append(ratingBintang).append(" bintang\n")
              .append(LBL_KOMENTAR).append("\n");
        for (Komentar komentar : daftarKomentar) {
            result.append("  - ").append(komentar.getKomentarText()).append("\n");
        }
        return result.toString();
    }

    public static Rating cariRating(String namaProduk, String namaPengguna) {
        for (Rating r : daftarRating) {
            if (r.getPengguna().equalsIgnoreCase(namaPengguna) && r.getNamaProduk().equalsIgnoreCase(namaProduk)) {
                return r;
            }
        }
        return null;
    }

    public void tampilkanDetail() {
        com.method.main.ConsoleUI.println("\nUlasan dan Rating");
        com.method.main.ConsoleUI.println(LBL_PENGGUNA + getPengguna());
        com.method.main.ConsoleUI.println(LBL_TANGGAL + getTanggalUlasan());
        com.method.main.ConsoleUI.println(LBL_RATING + getRatingBintang() + " bintang");
        com.method.main.ConsoleUI.println(LBL_KOMENTAR);
        for (Komentar komentar : getDaftarKomentar()) {
            com.method.main.ConsoleUI.println("  - " + komentar.getKomentarText());
        }
    }

    public static Rating cariDanTampilkanRating(java.util.Scanner scanner, String aksi) {
        com.method.main.ConsoleUI.print("Masukkan nama produk yang ulasannya ingin " + aksi + ": ");
        String namaProduk = scanner.nextLine();

        com.method.main.ConsoleUI.print("Masukkan nama pengguna yang ulasannya ingin " + aksi + ": ");
        String namaPengguna = scanner.nextLine();

        Rating ratingDipilih = cariRating(namaProduk, namaPengguna);

        if (ratingDipilih == null) {
            com.method.main.ConsoleUI.println("Ulasan untuk produk \"" + namaProduk + "\" dari pengguna \"" + namaPengguna + "\" tidak ditemukan!");
            return null;
        }

        ratingDipilih.tampilkanDetail();
        return ratingDipilih;
    }
    
    public static void hapusRating(String namaProduk, String pengguna) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarRating.size(); i++) {
            Rating rating = daftarRating.get(i);
            if (rating.getNamaProduk().equals(namaProduk) && rating.getPengguna().equals(pengguna)) {
                daftarRating.remove(i); 
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            com.method.main.ConsoleUI.println("Ulasan tidak ditemukan untuk produk " + namaProduk + " oleh pengguna " + pengguna + ".");
        }
    }
}
