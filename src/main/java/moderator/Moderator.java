package moderator;

import com.method.main.Pengguna;
import java.util.ArrayList;
import java.util.Scanner;

public class Moderator extends Pengguna {
    private int jumlahUlasanDihapus;
        
    private static final ArrayList<Moderator> daftarModerator = new ArrayList<>(
        java.util.Arrays.asList(new Moderator("Raffa Rizky Febryan ", "raffa@gmail.com", "raffa123", "085138229382"))
    );

    public Moderator(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
        this.jumlahUlasanDihapus = 0;
    }

    public static void loginModerator(Scanner scan) { 
        while (true) { 
            com.method.main.ConsoleUI.println("================================ Login Moderator =============================");
            String[] credentials = Pengguna.promptLogin(scan, "moderator");
            if (credentials.length == 0) break;

            Moderator moderator = cariModerator(credentials[0], credentials[1]);
            if (moderator != null) {
                com.method.main.ConsoleUI.println("Login berhasil. Selamat datang, " + moderator.getNama() + "!");
                MenuModerator menu = new MenuModerator(moderator);
                menu.aksi(scan); 
            } else {
                com.method.main.ConsoleUI.println("Login gagal. Email atau password salah. Coba lagi.");
            }
        }
    }
     
    @Override
    public void jenisPengguna(){
        com.method.main.ConsoleUI.println("================================== Moderator =================================");
        super.tampilkanProfil();
        com.method.main.ConsoleUI.println("Jumlah Ulasan Dihapus : " + jumlahUlasanDihapus);
    }

    public static Moderator cariModerator(String email, String password) {
        for (Moderator moderator : daftarModerator) {
            if (moderator.getEmail().equals(email) && moderator.getPassword().equals(password)) {
                return moderator;
            }
        }
        return null;
    }

    public int getJumlahUlasanDihapus() {
        return jumlahUlasanDihapus;
    }
    
    public void setJumlahUlasanDihapus(int jumlahUlasanDihapus) {
        this.jumlahUlasanDihapus += jumlahUlasanDihapus;
    }
}
