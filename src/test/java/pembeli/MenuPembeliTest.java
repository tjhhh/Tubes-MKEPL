package pembeli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MenuPembeliTest {

    private Pembeli pembeli;
    private MenuPembeli menuPembeli;

    @BeforeEach
    void setUp() {
        pembeli = new Pembeli("Budi", "budi@gmail.com", "budi123", "08123456789");
        menuPembeli = new MenuPembeli(pembeli);
    }

    @Test
    void testAksiLihatProduk() {
        String input = "1\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPembeli.aksi(scanner));
    }

    @Test
    void testAksiLihatProdukSudahDibeli() {
        String input = "2\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPembeli.aksi(scanner));
    }

    @Test
    void testAksiBerikanRating() {
        // Simulasi input berikan rating
        // Karena membutuhkan Produk dan sebagainya, kita akan coba simple path
        // Pembeli perlu produk untuk dirating, defaultnya kosong
        String input = "3\nLaptop ABC\n5\nBagus\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPembeli.aksi(scanner));
    }

    @Test
    void testAksiLihatProdukDiberiRating() {
        String input = "4\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPembeli.aksi(scanner));
    }

    @Test
    void testAksiProfil() {
        String input = "5\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPembeli.aksi(scanner));
    }

    @Test
    void testAksiInvalid() {
        String input = "99\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPembeli.aksi(scanner));
    }
}
