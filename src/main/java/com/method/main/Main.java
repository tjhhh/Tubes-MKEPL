package com.method.main;

import pembeli.Pembeli;
import java.util.InputMismatchException;
import java.util.Scanner;
import moderator.Moderator;
import penjual.Penjual;

public class Main {
    private static final String BORDER_EQUAL = "|============================================================================|";
    private static final String BORDER_DASH  = "|----------------------------------------------------------------------------|";
    private static final String BORDER_EMPTY = "|                                                                            |";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                ConsoleUI.println("|========================= SISTEM ULASAN TOKO ONLINE ========================|");
                ConsoleUI.println(BORDER_EMPTY);
                ConsoleUI.println(BORDER_DASH);
                ConsoleUI.println("|                                  M E N U                                   |");
                ConsoleUI.println(BORDER_DASH);
                ConsoleUI.println("|  1. Login sebagai Pembeli                                                  |");
                ConsoleUI.println("|  2. Login sebagai Penjual                                                  |");
                ConsoleUI.println("|  3. Login sebagai Moderator                                                |");
                ConsoleUI.println("|  4. Keluar dari Sistem                                                     |");
                ConsoleUI.println(BORDER_EQUAL);
                ConsoleUI.print("Pilih menu: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        Pembeli.loginPembeli(scanner);
                        break;
                    case 2:
                        Penjual.loginPenjual(scanner);
                        break;
                    case 3:
                        Moderator.loginModerator(scanner);
                        break;
                    case 4:
                        ConsoleUI.println(BORDER_EQUAL);
                        ConsoleUI.println("|                Terima kasih telah menggunakan layanan kami!                |");
                        ConsoleUI.println(BORDER_EQUAL);
                        scanner.close();
                        return;
                    default:
                        ConsoleUI.println("Pilihan tidak valid. Mohon pilih menu yang tersedia.");
                }
            } catch (InputMismatchException e) {
                ConsoleUI.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
            } catch (Exception e) {
                ConsoleUI.println("Terjadi kesalahan: " + e.getMessage());
                throw e; 
            }
        }
    }
}
