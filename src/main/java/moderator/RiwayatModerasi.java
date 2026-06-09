package moderator;

import java.util.ArrayList;

public class RiwayatModerasi {
    private static final ArrayList<String> riwayat = new ArrayList<>();
    
    public static void tambahRiwayatHapusUlasan(String namaProduk, String namaPengguna, String isiUlasan){
        String entri = "Ulasan oleh pengguna '" + namaPengguna + "' untuk produk '" + namaProduk + "' telah dihapus.\n" + 
                        "Isi Ulasan Sebelum Dihapus:\n" + isiUlasan;
        riwayat.add(entri);
    }
    
    public static void tampilkanRiwayat() {
        com.method.main.ConsoleUI.println("============================== Riwayat Moderasi ==============================");
        if (riwayat.isEmpty()) {
            com.method.main.ConsoleUI.println("Tidak ada riwayat moderasi");
        } else {
            for (int i = 0; i < riwayat.size(); i++) {
                com.method.main.ConsoleUI.println((i + 1) + ". " + riwayat.get(i));
            }
        }
    }
}
