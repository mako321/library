package com.github.mako321.Services;

import com.github.mako321.Models.Volume;
import com.github.mako321.Repositories.Contracts.VolumeRepository;
import com.github.mako321.Repositories.VolumeInMemoryRepository;

import java.util.Optional;
import java.util.Scanner;

public class VolumeService {
    private final Scanner scanner;
    private final VolumeRepository volumeRepository;

    public VolumeService() {
        this.scanner = new Scanner(System.in);
        this.volumeRepository = new VolumeInMemoryRepository();
    }

    public Optional<Volume> enterVolume() {
        System.out.print("Wczytaj kod woluminu: ");

        return findVolumeById(scanner.nextInt());
    }

    public Optional<Volume> findVolumeById(Integer volumeId) {
        var volumeOptional = this.volumeRepository.findById(volumeId);
        if (volumeOptional.isEmpty()) {
            System.out.println("Wolumin nie został znaleziony");
            return Optional.empty();
        } else {
            System.out.println("Znaleziony wolumin: " + volumeOptional.get());
        }

        return volumeOptional;
    }
}
