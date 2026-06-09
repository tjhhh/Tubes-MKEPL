package com.method.main;

@SuppressWarnings("java:S106")
public class ConsoleUI {
    private ConsoleUI() {
        // Private constructor to hide implicit public one
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println() {
        System.out.println();
    }
}
