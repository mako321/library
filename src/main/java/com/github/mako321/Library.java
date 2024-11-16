package com.github.mako321;

import com.github.mako321.Seeders.MainSeeder;
import com.github.mako321.Services.CallSlipService;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        CallSlipService callSlipService = new CallSlipService();
        Scanner scanner = new Scanner(System.in);
        MainSeeder.seed(); // uzupełnienie danych (opcjonalnie)

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
                case 1 -> callSlipService.borrow();
                case 2 -> callSlipService.printAll();
                case 3 -> open = false;
                default -> System.out.println("Opcja niedostępna!");
            }
        }

        System.out.println("\nBiblioteka została zamknięta!");
    }
}
