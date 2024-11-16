package com.github.mako321.Repositories;

import com.github.mako321.Models.Reader;
import com.github.mako321.Repositories.Contracts.ReaderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ReaderRepositoryTest {

    ReaderRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ReaderInMemoryRepository();
    }

    @Test
    @DisplayName("Test saving a reader")
    public void shouldSaveReader() {
        // given
        var reader = new Reader(123, "Jan", "Kowalski", new LinkedList<>());

        // when
        repository.save(reader);

        // then
        var result = repository.findById(reader.getId());
        assertTrue(result.isPresent()); // czy znaleziono czytelnika?
        assertEquals(123, result.get().getId().intValue()); // czy zgadza się identyfikator?
        assertEquals(0, result.get().getCallSlips().size()); // czy lista wypożyczeń jest pusta?
    }

    @Test
    @DisplayName("Test finding a non-existing reader")
    public void shouldNotFindNonExistingReader() {
        // when
        var result = repository.findById(999);

        // then
        assertTrue(result.isEmpty(), "Reader should not be found in the repository");
    }
}