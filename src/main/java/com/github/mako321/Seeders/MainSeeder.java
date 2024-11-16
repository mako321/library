package com.github.mako321.Seeders;

import com.github.javafaker.Faker;
import com.github.mako321.Models.*;
import com.github.mako321.Repositories.Contracts.ReaderRepository;
import com.github.mako321.Repositories.Contracts.VolumeRepository;
import com.github.mako321.Repositories.ReaderInMemoryRepository;
import com.github.mako321.Repositories.VolumeInMemoryRepository;

import java.util.LinkedList;
import java.util.Locale;

public final class MainSeeder {

    public static void seed() {
        System.out.println("Generowanie danych");
        ReaderRepository readerRepository = new ReaderInMemoryRepository();
        VolumeRepository volumeRepository = new VolumeInMemoryRepository();

        Faker faker = new Faker(new Locale("pl-PL"));

        // wygenerowanie czytelników
        for (int i = 0; i < 4; i++) {
            var reader = new Reader(i + 100, faker.name().firstName(), faker.name().lastName(), new LinkedList<>());
            readerRepository.save(reader);
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
            volumeRepository.save(volume);
            System.out.println(volume);
        }

        System.out.println("Zakończono generowanie danych");
        System.out.println("==============================================");
    }
}
