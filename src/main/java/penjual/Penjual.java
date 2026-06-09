package penjual;

import java.util.ArrayList;
import java.util.Scanner;

import com.method.main.Pengguna;

public class Penjual extends Pengguna {

    private static final ArrayList<Penjual> daftarPenjual = new ArrayList<>(
        java.util.Arrays.asList(new Penjual("Rahmah Aisyah", "rahmah@gmail.com", "rahmah123", "085312436789"))
    );

    public Penjual(String nama, String email, String password, String nomorTelepon) {
        super(nama, email, password, nomorTelepon);
    }

    public static void loginPenjual(Scanner scan) {
        while (true) {
            com.method.main.ConsoleUI.println("================================ Login Penjual ===============================");
            String[] credentials = Pengguna.promptLogin(scan, "penjual");
            if (credentials.length == 0) break;

            Penjual penjual = cariPenjual(credentials[0], credentials[1]);
            if (penjual != null) {
                com.method.main.ConsoleUI.println("Login berhasil. Selamat datang, " + penjual.getNama() + "!");
                MenuPenjual menu = new MenuPenjual(penjual);
                menu.aksi(scan);
            } else {
                com.method.main.ConsoleUI.println("Login gagal. Email atau password salah. Coba lagi.");
            }
        }
    }

    public static Penjual cariPenjual(String email, String password) {
        for (Penjual penjual : daftarPenjual) {
            if (penjual.getEmail().equals(email) && penjual.getPassword().equals(password)) {
                return penjual;
            }
        }
        return null;
    }

    @Override
    public void jenisPengguna() {
        com.method.main.ConsoleUI.println("=================================== Penjual ==================================");
        super.tampilkanProfil();
    }
}
