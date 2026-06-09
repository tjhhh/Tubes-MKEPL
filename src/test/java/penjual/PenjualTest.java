package penjual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PenjualTest {

    private Penjual penjual;

    @BeforeEach
    public void setUp() {
        penjual = new Penjual("Joko", "joko@gmail.com", "joko123", "08198765432");
    }

    @Test
    public void testCariPenjualValid() {
        Penjual found = Penjual.cariPenjual("rahmah@gmail.com", "rahmah123");
        assertNotNull(found);
        assertEquals("Rahmah Aisyah", found.getNama());
    }

    @Test
    public void testCariPenjualInvalid() {
        Penjual found = Penjual.cariPenjual("invalid@gmail.com", "wrong");
        assertNull(found);
    }

    @Test
    public void testJenisPengguna() {
        assertDoesNotThrow(() -> penjual.jenisPengguna());
    }

    @Test
    public void testLoginPenjualInvalid() {
        String input = "wrong@gmail.com\nwrongpass\nexit\n";
        java.io.InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        java.util.Scanner scanner = new java.util.Scanner(in);
        assertDoesNotThrow(() -> Penjual.loginPenjual(scanner));
    }

    @Test
    public void testLoginPenjualValid() {
        String input = "rahmah@gmail.com\nrahmah123\n3\nexit\n";
        java.io.InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        java.util.Scanner scanner = new java.util.Scanner(in);
        assertDoesNotThrow(() -> Penjual.loginPenjual(scanner));
    }
}
