package com.github.mako321.Services;

import com.github.mako321.Models.Reader;
import com.github.mako321.Repositories.Contracts.ReaderRepository;
import com.github.mako321.Repositories.ReaderInMemoryRepository;

import java.util.Optional;
import java.util.Scanner;

public class ReaderService {
    private final Integer MAX_LIMIT = 5;
    private final Scanner scanner;
    private final ReaderRepository readerRepository;

    public ReaderService() {
        this.scanner = new Scanner(System.in);
        this.readerRepository = new ReaderInMemoryRepository();
    }

    public Optional<Reader> enterReader() {
        System.out.print("Wczytaj kod czytelnika: ");

        return findReaderById(scanner.nextInt());
    }

    public Optional <Reader> findReaderById(Integer readerId) {
        var readerOptional = this.readerRepository.findById(readerId);
        if (readerOptional.isEmpty()) {
            System.out.println("Czytelnik nie został znaleziony");
        } else {
            System.out.println("Znaleziony czytelnik: " + readerOptional.get());
        }

        return readerOptional;
    }

    public boolean isMaxBorrowLimitReached(Reader reader) {
        int count = reader.getCallSlips().size();
        System.out.printf("Liczba wypożyczonych pozycji: %d.\n", count);

        return count >= MAX_LIMIT;
    }

    public Reader save(Reader reader) {
        return this.readerRepository.save(reader);
    }
}
