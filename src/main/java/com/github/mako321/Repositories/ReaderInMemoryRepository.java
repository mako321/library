package com.github.mako321.Repositories;

import com.github.mako321.Models.Reader;
import com.github.mako321.Repositories.Contracts.ReaderRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ReaderInMemoryRepository implements ReaderRepository {

    private static final List<Reader> readers = new LinkedList<>();

    public Optional<Reader> findById(int id) {
        return readers
                .stream()
                .filter(reader -> reader.getId() == id)
                .findFirst();
    }

    public Reader save(Reader reader) {
        readers.add(reader);

        return reader;
    }
}
