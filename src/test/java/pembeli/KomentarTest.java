package pembeli;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class KomentarTest {

    @Test
    public void testConstructorAndGetters() {
        Komentar komentar = new Komentar("Barang mantap");
        assertEquals("Barang mantap", komentar.getKomentarText());
        assertNotNull(komentar.getBalasan());
        assertTrue(komentar.getBalasan().isEmpty());
    }

    @Test
    public void testTambahBalasan() {
        Komentar komentar = new Komentar("Barang kurang cepat sampai");
        komentar.tambahBalasan("Mohon maaf atas keterlambatannya.");
        
        ArrayList<String> balasan = komentar.getBalasan();
        assertEquals(1, balasan.size());
        assertEquals("Mohon maaf atas keterlambatannya.", balasan.get(0));
    }

    @Test
    public void testToStringFormat() {
        Komentar komentar = new Komentar("Bagus");
        komentar.tambahBalasan("Terima kasih!");
        
        String expected = "Bagus\n  Balasan:\n    - Terima kasih!";
        assertEquals(expected, komentar.toString());
    }

    @Test
    public void testGetDaftarKomentar() {
        ArrayList<Komentar> daftar = Komentar.getDaftarKomentar();
        assertNotNull(daftar);
        assertEquals(4, daftar.size());
        assertEquals("Barang sangat bagus, sesuai ekspektasi.", daftar.get(0).getKomentarText());
    }
}
