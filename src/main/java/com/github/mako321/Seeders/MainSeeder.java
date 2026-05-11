package com.github.mako321.Seeders;

import com.github.javafaker.Faker;
import com.github.mako321.Library;
import com.github.mako321.Models.Book;
import com.github.mako321.Models.Item;
import com.github.mako321.Models.Magazine;
import com.github.mako321.Models.Reader;
import com.github.mako321.Models.Volume;

import java.util.LinkedList;
import java.util.Locale;

public final class MainSeeder {

    public static void seed(Library library) {
        System.out.println("Generowanie danych");

        Faker faker = new Faker(new Locale("pl-PL"));

        // wygenerowanie czytelników
        for (int i = 0; i < 4; i++) {
            var reader = new Reader(i + 100, faker.name().firstName(), faker.name().lastName(), new LinkedList<>());
            library.addReader(reader);
            System.out.println(reader);
        }

        for (int i = 0; i < 6; i++) {
            // wygenerowanie czasopism i książek
            Item item;
            if (i % 2 == 0) {
                item = new Magazine(i + 200, faker.book().title(), i + 1);
            } else {
                item = new Book(i + 200, faker.book().title(), faker.book().author());
            }

            // utworzenie woluminu
            var volume = new Volume(i + 300, item);
            library.addVolume(volume);
            System.out.println(volume);
        }

        System.out.println("Zakończono generowanie danych");
        System.out.println("==============================================");
    }
}
