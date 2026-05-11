package com.github.mako321;

import com.github.mako321.Models.CallSlip;
import com.github.mako321.Models.Reader;
import com.github.mako321.Models.Volume;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static final int MAX_BORROW_LIMIT = 5;

    private final List<Reader> readers = new LinkedList<>();
    private final List<Volume> volumes = new LinkedList<>();
    private final List<CallSlip> callSlips = new LinkedList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void addVolume(Volume volume) {
        volumes.add(volume);
    }

    public Reader findReader(int id) {
        for (Reader reader : readers) {
            if (reader.getId() == id) {
                return reader;
            }
        }
        return null;
    }

    public Volume findVolume(int id) {
        for (Volume volume : volumes) {
            if (volume.getId() == id) {
                return volume;
            }
        }
        return null;
    }

    public boolean isVolumeBorrowed(int volumeId) {
        for (CallSlip callSlip : callSlips) {
            if (callSlip.getVolume().getId() == volumeId) {
                return true;
            }
        }
        return false;
    }

    public void borrow() {
        // wczytanie woluminu
        System.out.print("Wczytaj kod woluminu: ");
        Volume volume = findVolume(scanner.nextInt());
        if (volume == null) {
            System.out.println("Wolumin nie został znaleziony");
            return;
        }
        System.out.println("Znaleziony wolumin: " + volume);

        if (isVolumeBorrowed(volume.getId())) {
            System.out.println("Wolumin został wypożyczony, nie jest dostępny!");
            return;
        }

        // wczytanie czytelnika
        System.out.print("Wczytaj kod czytelnika: ");
        Reader reader = findReader(scanner.nextInt());
        if (reader == null) {
            System.out.println("Czytelnik nie został znaleziony");
            return;
        }
        System.out.println("Znaleziony czytelnik: " + reader);

        int count = reader.getCallSlips().size();
        System.out.printf("Liczba wypożyczonych pozycji: %d.%n", count);
        if (count >= MAX_BORROW_LIMIT) {
            System.out.println("Przekroczono liczbę wypożyczeń!");
            return;
        }

        // zapis rewersu
        var callSlip = new CallSlip(volume, reader);
        reader.addCallSlip(callSlip);
        callSlips.add(callSlip);
        System.out.println("Rewers został zapisany -> " + callSlip + "\n");
    }

    public void printAll() {
        if (callSlips.isEmpty()) {
            System.out.println("Brak!");
            return;
        }
        for (CallSlip callSlip : callSlips) {
            System.out.println(callSlip);
        }
    }
}
