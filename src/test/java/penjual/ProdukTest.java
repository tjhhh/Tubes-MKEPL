package penjual;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

class ProdukTest {

    @Test
    void testConstructorAndGetters() {
        Produk produk = new Produk("Laptop ABC", 5000000, "Laptop dengan spesifikasi tinggi");
        assertEquals("Laptop ABC", produk.getNama());
    }

    @Test
    void testDefaultConstructor() {
        Produk produk = new Produk();
        assertNull(produk.getNama());
    }

    @Test
    void testInitializeDaftarProduk() {
        Produk.initializeDaftarProduk();
        Map<String, ArrayList<Produk>> daftar = Produk.getDaftarProduk();
        assertNotNull(daftar);
        assertTrue(daftar.containsKey("Rahmah"));
        
        ArrayList<Produk> produkRahmah = daftar.get("Rahmah");
        assertEquals(2, produkRahmah.size());
        assertEquals("Laptop ABC", produkRahmah.get(0).getNama());
        assertEquals("Headphone DEF", produkRahmah.get(1).getNama());
    }
}
