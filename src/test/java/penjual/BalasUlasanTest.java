package penjual;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BalasUlasanTest {

    @Test
    void testBalasUlasanDitemukan() {
        // Produk: "Laptop ABC", Pengguna: "Kroos", Balasan: "Terima kasih"
        String input = "Laptop ABC\nKroos\nTerima kasih\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> BalasUlasan.balasUlasan(scanner));
    }

    @Test
    void testBalasUlasanTidakDitemukan() {
        String input = "Produk Palsu\nPengguna Palsu\nTerima kasih\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> BalasUlasan.balasUlasan(scanner));
    }
}
