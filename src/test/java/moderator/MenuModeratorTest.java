package moderator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MenuModeratorTest {

    private Moderator moderator;
    private MenuModerator menuModerator;

    @BeforeEach
    void setUp() {
        moderator = new Moderator("Raffa", "raffa@gmail.com", "raffa123", "085138229382");
        menuModerator = new MenuModerator(moderator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n6\n", "2\nLaptop ABC\nKroos\n6\n", "3\n6\n", "99\n6\n"})
    void testAksiMenuModerator(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        assertDoesNotThrow(() -> menuModerator.aksi(scanner));
    }
}
