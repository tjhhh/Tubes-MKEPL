package com.method.main;

public abstract class Pengguna {
    private String nama;
    private String email;
    private String password;
    private String nomorTelepon;

    public Pengguna(String nama, String email, String password, String nomorTelepon) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nomorTelepon = nomorTelepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        } else {
            com.method.main.ConsoleUI.println("Nama tidak boleh kosong.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            com.method.main.ConsoleUI.println("Email tidak valid.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            com.method.main.ConsoleUI.println("Password harus memiliki minimal 6 karakter.");
        }
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        if (nomorTelepon != null && nomorTelepon.length() >= 10) {
            this.nomorTelepon = nomorTelepon;
        } else {
            com.method.main.ConsoleUI.println("Nomor telepon harus memiliki minimal 10 digit.");
        }
    }

    public abstract void jenisPengguna();

    public void tampilkanProfil() {
        com.method.main.ConsoleUI.println("Nama         : " + nama);
        com.method.main.ConsoleUI.println("Email        : " + email);
        com.method.main.ConsoleUI.println("Nomor Telepon: " + nomorTelepon);
        com.method.main.ConsoleUI.println();
    }

    public static String[] promptLogin(java.util.Scanner scan, String role) {
        com.method.main.ConsoleUI.println("Ketik 'exit' untuk keluar dari login " + role + ".");
        com.method.main.ConsoleUI.print("Email: ");
        String email = scan.nextLine();
        if (email.equalsIgnoreCase("exit")) {
            com.method.main.ConsoleUI.println("Anda keluar dari login " + role + ".");
            return null;
        }
        com.method.main.ConsoleUI.print("Password: ");
        String password = scan.nextLine();
        return new String[]{email, password};
    }
}
