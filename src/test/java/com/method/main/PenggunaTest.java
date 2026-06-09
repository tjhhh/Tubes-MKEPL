package com.method.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PenggunaTest {

    private Pengguna pengguna;

    @BeforeEach
    void setUp() {
        pengguna = new Pengguna("Test User", "test@gmail.com", "password", "08123456789") {
            @Override
            public void jenisPengguna() {
                // Dummy implementation for abstract method
            }
        };
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("Test User", pengguna.getNama());
        assertEquals("test@gmail.com", pengguna.getEmail());
        assertEquals("password", pengguna.getPassword());
        assertEquals("08123456789", pengguna.getNomorTelepon());
    }

    @Test
    void testSetNama() {
        pengguna.setNama("New Name");
        assertEquals("New Name", pengguna.getNama());

        // Invalid name
        pengguna.setNama("");
        assertEquals("New Name", pengguna.getNama()); // should not change

        pengguna.setNama(null);
        assertEquals("New Name", pengguna.getNama()); // should not change
    }

    @Test
    void testSetEmail() {
        pengguna.setEmail("new@gmail.com");
        assertEquals("new@gmail.com", pengguna.getEmail());

        // Invalid email
        pengguna.setEmail("invalidemail.com");
        assertEquals("new@gmail.com", pengguna.getEmail()); // should not change
    }

    @Test
    void testSetPassword() {
        pengguna.setPassword("newpass");
        assertEquals("newpass", pengguna.getPassword());

        // Invalid password
        pengguna.setPassword("short");
        assertEquals("newpass", pengguna.getPassword()); // should not change
    }

    @Test
    void testSetNomorTelepon() {
        pengguna.setNomorTelepon("08987654321");
        assertEquals("08987654321", pengguna.getNomorTelepon());

        // Invalid phone
        pengguna.setNomorTelepon("123");
        assertEquals("08987654321", pengguna.getNomorTelepon()); // should not change
    }

    @Test
    void testTampilkanProfil() {
        assertDoesNotThrow(() -> pengguna.tampilkanProfil());
    }
}
