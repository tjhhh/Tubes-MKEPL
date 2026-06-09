package pembeli;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KomentarTest {

    @Test
    void testConstructorAndGetters() {
        Komentar komentar = new Komentar("Test Komentar");
        assertEquals("Test Komentar", komentar.getKomentarText());
        assertNotNull(komentar.getBalasan());
        assertTrue(komentar.getBalasan().isEmpty());
    }

    @Test
    void testTambahBalasan() {
        Komentar komentar = new Komentar("Test Komentar");
        komentar.tambahBalasan("Balasan 1");
        komentar.tambahBalasan("Balasan 2");

        assertEquals(2, komentar.getBalasan().size());
        assertEquals("Balasan 1", komentar.getBalasan().get(0));
        assertEquals("Balasan 2", komentar.getBalasan().get(1));
    }

    @Test
    void testGetDaftarKomentar() {
        ArrayList<Komentar> daftar = Komentar.getDaftarKomentar();
        assertNotNull(daftar);
        assertEquals(4, daftar.size());
        assertEquals("Barang sangat bagus, sesuai ekspektasi.", daftar.get(0).getKomentarText());
    }

    @Test
    void testToString() {
        Komentar komentar = new Komentar("Test");
        komentar.tambahBalasan("Balasan");
        String result = komentar.toString();

        assertTrue(result.contains("Test"));
        assertTrue(result.contains("Balasan:"));
        assertTrue(result.contains("- Balasan"));
    }
}
