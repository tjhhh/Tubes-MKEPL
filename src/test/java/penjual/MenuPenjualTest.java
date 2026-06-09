package penjual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MenuPenjualTest {

    private Penjual penjual;
    private MenuPenjual menuPenjual;

    @BeforeEach
    void setUp() {
        penjual = new Penjual("Joko", "joko@gmail.com", "joko123", "08198765432");
        menuPenjual = new MenuPenjual(penjual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n3\n3\n", "2\n3\n", "99\n3\n"})
    void testAksiMenuPenjual(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuPenjual.aksi(scanner));
    }
}
