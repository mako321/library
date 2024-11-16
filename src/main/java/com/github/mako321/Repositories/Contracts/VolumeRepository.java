package com.github.mako321.Repositories.Contracts;

import com.github.mako321.Models.Volume;

import java.util.Optional;

public interface VolumeRepository {
    Optional<Volume> findById(int id);
    Volume save(Volume volume);
}
