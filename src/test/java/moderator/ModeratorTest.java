package moderator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModeratorTest {

    private Moderator moderator;

    @BeforeEach
    public void setUp() {
        moderator = new Moderator("Mod1", "mod1@gmail.com", "modpass", "08111222333");
    }

    @Test
    public void testCariModeratorValid() {
        Moderator found = Moderator.cariModerator("raffa@gmail.com", "raffa123");
        assertNotNull(found);
        assertEquals("Raffa Rizky Febryan ", found.getNama());
    }

    @Test
    public void testCariModeratorInvalid() {
        Moderator found = Moderator.cariModerator("wrong@gmail.com", "wrong");
        assertNull(found);
    }

    @Test
    public void testSetJumlahUlasanDihapus() {
        assertEquals(0, moderator.getJumlahUlasanDihapus());
        moderator.setJumlahUlasanDihapus(2);
        assertEquals(2, moderator.getJumlahUlasanDihapus());
    }

    @Test
    public void testJenisPengguna() {
        assertDoesNotThrow(() -> moderator.jenisPengguna());
    }

    @Test
    public void testLoginModeratorInvalid() {
        String input = "wrong@gmail.com\nwrongpass\nexit\n";
        java.io.InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        java.util.Scanner scanner = new java.util.Scanner(in);
        assertDoesNotThrow(() -> Moderator.loginModerator(scanner));
    }

    @Test
    public void testLoginModeratorValid() {
        String input = "raffa@gmail.com\nraffa123\n6\nexit\n";
        java.io.InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        java.util.Scanner scanner = new java.util.Scanner(in);
        assertDoesNotThrow(() -> Moderator.loginModerator(scanner));
    }
}
