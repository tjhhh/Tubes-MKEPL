package penjual;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pembeli.Komentar;
import pembeli.Rating;

public class Produk {
    private String nama;
    private int harga;
    private String deskripsi;
    private ArrayList<Komentar> daftarUlasan;

    private static Map<String, ArrayList<Produk>> daftarProduk = new HashMap<>();
    
    public Produk(String nama, int harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }
    public Produk() {
    }
    
    /**
     *
     */
    public static void initializeDaftarProduk(){
        ArrayList<Produk> produkRahmah = new ArrayList<>();
        produkRahmah.add(new Produk("Laptop ABC", 5000000, "Laptop dengan spesifikasi tinggi dan desain elegan."));
        produkRahmah.add(new Produk("Headphone DEF", 300000, "Headphone dengan kualitas suara terbaik dan nyaman digunakan."));
        
        daftarProduk.put("Rahmah", produkRahmah);
    }
    
    public static Map<String, ArrayList<Produk>> getDaftarProduk() {
        return daftarProduk;
    }

    public static void tampilkanSemuaProduk() {
        initializeDaftarProduk();
        if (getDaftarProduk().isEmpty()) {
            com.method.main.ConsoleUI.println("Tidak ada produk yang tersedia.");
        } else {
            com.method.main.ConsoleUI.println("==============================================================================");
            com.method.main.ConsoleUI.println("                                DAFTAR PRODUK                               ");
            com.method.main.ConsoleUI.println("==============================================================================");
            
            for (Map.Entry<String, ArrayList<Produk>> entry : getDaftarProduk().entrySet()) {
                String penjual = entry.getKey();
                ArrayList<Produk> produkList = entry.getValue();
                
                com.method.main.ConsoleUI.println("Penjual\t\t: " + penjual);
                for (Produk produk : produkList) {
                    produk.tampilkanInfo();
                    com.method.main.ConsoleUI.println("\nUlasan dan Rating");
                    Rating.tampilkanRating(produk.getNama()); 
                    com.method.main.ConsoleUI.println("------------------------------------------------------------------------------");
                }
            }
        }
    }

    public void tampilkanInfo() {
        com.method.main.ConsoleUI.println("Nama Produk\t: " + nama);
        com.method.main.ConsoleUI.println("Harga\t\t: Rp" + harga);
        com.method.main.ConsoleUI.println("Deskripsi\t: " + deskripsi);
    }
    
    public String getNama() {
        return nama;
    }
    
    public void tambahUlasan(Komentar komentar) {
        daftarUlasan.add(komentar);
    }
    
    public void menuProduk(Scanner scanner){
        initializeDaftarProduk();
            while(true) {
                tampilkanSemuaProduk();
                com.method.main.ConsoleUI.println("================================ Tinjau Produk ===============================");
                com.method.main.ConsoleUI.println("1. Balas Ulasan");
                com.method.main.ConsoleUI.println("2. Lapor Ulasan");
                com.method.main.ConsoleUI.println("3. Keluar");
                com.method.main.ConsoleUI.print("Pilih menu: ");
                int pilih = scanner.nextInt();

                switch(pilih) {
                    case 1 :
                        BalasUlasan.balasUlasan(scanner);
                        break;
                    case 2 :
                        LaporUlasan.pilihDanLaporUlasan(scanner);
                        break;
                    case 3:
                        com.method.main.ConsoleUI.println("Kembali ke menu sebelumnya...");
                        return;
                    default:
                        com.method.main.ConsoleUI.println("Pilihan tidak valid! Silakan coba lagi.");
                }
            }
    }  
}