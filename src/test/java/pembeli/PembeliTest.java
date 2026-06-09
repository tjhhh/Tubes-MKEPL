package pembeli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

class PembeliTest {

    private Pembeli pembeli;

    @BeforeEach
    void setUp() {
        pembeli = new Pembeli("Budi", "budi@gmail.com", "budi123", "08123456789");
    }

    @Test
    void testConstructorAndGetters() {
        Pembeli found = Pembeli.cariPembeli("dhea@gmail.com", "dhea123");
        assertNotNull(found);
        assertEquals("Dhea Sri Noor Septianiz", found.getNama());
    }

    @Test
    void testCariPembeliInvalid() {
        Pembeli found = Pembeli.cariPembeli("invalid@gmail.com", "wrongpass");
        assertNull(found);
    }

    @Test
    void testTampilkanProdukSudahDibeli() {
        assertDoesNotThrow(() -> pembeli.tampilkanProdukSudahDibeli());
    }

    @Test
    void testTampilkanProdukDiberiRating() {
        assertDoesNotThrow(() -> pembeli.tampilkanProdukDiberiRating());
    }

    @Test
    void testJenisPengguna() {
        assertDoesNotThrow(() -> pembeli.jenisPengguna());
    }

    @Test
    void testLoginPembeliInvalid() {
        String input = "wrong@gmail.com\nwrongpass\nexit\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        java.util.Scanner scanner = new java.util.Scanner(in);
        assertDoesNotThrow(() -> Pembeli.loginPembeli(scanner));
    }

    @Test
    void testLoginPembeliValid() {
        String input = "dhea@gmail.com\ndhea123\n6\nexit\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        java.util.Scanner scanner = new java.util.Scanner(in);
        assertDoesNotThrow(() -> Pembeli.loginPembeli(scanner));
    }
}
