package pembeli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = new Rating("Test Produk", "UserTest", "2024-01-01", 5);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Test Produk", rating.getNamaProduk());
        assertEquals("UserTest", rating.getPengguna());
        assertEquals("2024-01-01", rating.getTanggalUlasan());
        assertEquals(5, rating.getRatingBintang());
        assertNotNull(rating.getDaftarKomentar());
        assertTrue(rating.getDaftarKomentar().isEmpty());
    }

    @Test
    void testTambahKomentar() {
        Komentar komentar = new Komentar("Komentar Test");
        rating.tambahKomentar(komentar);

        assertEquals(1, rating.getDaftarKomentar().size());
        assertEquals("Komentar Test", rating.getDaftarKomentar().get(0).getKomentarText());
    }

    @Test
    void testGetDaftarRating() {
        ArrayList<Rating> daftar = Rating.getDaftarRating();
        assertNotNull(daftar);
        assertFalse(daftar.isEmpty());
        assertEquals("Laptop ABC", daftar.get(0).getNamaProduk());
    }

    @Test
    void testTampilkanRatingFound() {
        assertDoesNotThrow(() -> Rating.tampilkanRating("Laptop ABC"));
    }

    @Test
    void testTampilkanRatingNotFound() {
        assertDoesNotThrow(() -> Rating.tampilkanRating("Produk Tidak Ada"));
    }

    @Test
    void testToString() {
        Komentar komentar = new Komentar("Bagus");
        rating.tambahKomentar(komentar);
        
        String result = rating.toString();
        assertTrue(result.contains("Pengguna       : UserTest"));
        assertTrue(result.contains("Tanggal Ulasan : 2024-01-01"));
        assertTrue(result.contains("Rating         : 5 bintang"));
        assertTrue(result.contains("- Bagus"));
    }

    @Test
    void testHapusRating() {
        Rating temp = new Rating("Temp Produk", "Temp User", "2024-01-01", 5);
        Rating.getDaftarRating().add(temp);
        
        int sizeBefore = Rating.getDaftarRating().size();
        
        // Hapus yang baru ditambahkan
        Rating.hapusRating("Temp Produk", "Temp User");
        assertEquals(sizeBefore - 1, Rating.getDaftarRating().size());
        
        // Hapus yang tidak ada
        assertDoesNotThrow(() -> Rating.hapusRating("Temp Produk", "TidakAda"));
    }
}
