package com.github.mako321.Repositories;

import com.github.mako321.Models.Volume;
import com.github.mako321.Repositories.Contracts.VolumeRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VolumeInMemoryRepository implements VolumeRepository {

    private static final List<Volume> volumes = new LinkedList<>();

    public Optional<Volume> findById(int id) {
        return volumes
                .stream()
                .filter(reader -> reader.getId() == id)
                .findFirst();
    }

    public Volume save(Volume volume) {
        volumes.add(volume);

        return volume;
    }
}
