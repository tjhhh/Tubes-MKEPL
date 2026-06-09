package moderator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RiwayatModerasiTest {

    @Test
    void testTambahDanTampilkanRiwayat() {
        assertDoesNotThrow(() -> RiwayatModerasi.tambahRiwayatHapusUlasan("Produk X", "User Y", "Komentar buruk"));
        assertDoesNotThrow(() -> RiwayatModerasi.tampilkanRiwayat());
    }
}
