package penjual;

import org.junit.jupiter.api.Test;
import pembeli.Komentar;
import pembeli.Rating;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LaporUlasanTest {

    @Test
    void testPilihDanLaporUlasanYa() {
        // Tambahkan dummy rating dulu agar pasti ada
        Rating dummy = new Rating("Produk Dummy Lapor", "User Dummy Lapor", "2024-01-01", 1);
        dummy.tambahKomentar(new Komentar("Jelek"));
        Rating.getDaftarRating().add(dummy);

        String input = "Produk Dummy Lapor\nUser Dummy Lapor\nya\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> LaporUlasan.pilihDanLaporUlasan(scanner));
        
        // Verifikasi bahwa laporan sudah ditambahkan
        assertFalse(LaporUlasan.getUlasanDilanggar().isEmpty());
    }

    @Test
    void testPilihDanLaporUlasanTidak() {
        String input = "Headphone DEF\nWanda\ntidak\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> LaporUlasan.pilihDanLaporUlasan(scanner));
    }

    @Test
    void testPilihDanLaporUlasanTidakDitemukan() {
        String input = "Invalid Produk\nInvalid User\nya\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> LaporUlasan.pilihDanLaporUlasan(scanner));
    }

    @Test
    void testTampilkanLaporan() {
        // Pastikan tampilkanLaporan bisa dieksekusi tanpa error
        assertDoesNotThrow(() -> LaporUlasan.tampilkanLaporan());
    }

    @Test
    void testConstructorAndGetters() {
        LaporUlasan lapor = new LaporUlasan("Produk X", "User Y", "Komentar Z");
        assertEquals("Produk X", lapor.getNamaProduk());
        assertEquals("User Y", lapor.getNamaPengguna());
        assertEquals("Komentar Z", lapor.getKomentar());
    }
}
