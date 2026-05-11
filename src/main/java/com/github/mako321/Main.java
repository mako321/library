package com.github.mako321;

import com.github.mako321.Seeders.MainSeeder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        MainSeeder.seed(library); // uzupełnienie danych (opcjonalnie)

        Scanner scanner = new Scanner(System.in);
        System.out.println("Biblioteka czynna!");

        boolean open = true;
        while (open) {
            System.out.print(
                    "==============================================" +
                    "\nDostępne opcje: " +
                    "\n \t 1. Wypożyczenie pozycji " +
                    "\n \t 2. Aktywne wypożyczenia " +
                    "\n \t 3. Zakończenie pracy " +
                    "\n Wybierz opcję (1-3): "
            );

            int option = scanner.nextInt();
            System.out.println("==============================================");

            switch (option) {
                case 1 -> library.borrow();
                case 2 -> library.printAll();
                case 3 -> open = false;
                default -> System.out.println("Opcja niedostępna!");
            }
        }

        System.out.println("\nBiblioteka została zamknięta!");
    }
}
