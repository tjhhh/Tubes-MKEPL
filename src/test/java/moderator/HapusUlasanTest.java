package moderator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HapusUlasanTest {

    @Test
    void testPilihDanHapusUlasanDitemukan() {
        // Pastikan Rating ada
        String input = "Headphone DEF\nModric\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        Moderator moderator = new Moderator("Raffa", "raffa@gmail.com", "raffa123", "08123");

        assertDoesNotThrow(() -> HapusUlasan.hapusUlasan(moderator, scanner));
    }

    @Test
    void testHapusUlasanTidakDitemukan() {
        String input = "Produk Palsu\nPengguna Palsu\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        Moderator moderator = new Moderator("Raffa", "raffa@gmail.com", "raffa123", "08123");

        assertDoesNotThrow(() -> HapusUlasan.hapusUlasan(moderator, scanner));
    }
}
