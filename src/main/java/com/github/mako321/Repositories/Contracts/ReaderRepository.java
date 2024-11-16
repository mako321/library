package com.github.mako321.Repositories.Contracts;

import com.github.mako321.Models.Reader;

import java.util.Optional;

public interface ReaderRepository {
    Optional<Reader> findById(int id);
    Reader save(Reader reader);
}
