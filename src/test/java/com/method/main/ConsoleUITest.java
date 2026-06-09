package com.method.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPrint() {
        ConsoleUI.print("Hello");
        assertEquals("Hello", outContent.toString());
    }

    @Test
    void testPrintlnWithMessage() {
        ConsoleUI.println("Hello");
        assertEquals("Hello" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testPrintlnEmpty() {
        ConsoleUI.println();
        assertEquals(System.lineSeparator(), outContent.toString());
    }
}
