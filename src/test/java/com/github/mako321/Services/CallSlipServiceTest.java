package com.github.mako321.Services;

import com.github.mako321.Models.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CallSlipServiceTest {

    CallSlipService callSlipService;
    Faker faker;

    @BeforeEach
    public void setUp() {
        callSlipService = new CallSlipService();
        faker = new Faker();
    }

    @Test
    public void shouldSaveBorrow() {
        // Given
        Reader reader = new Reader(
                faker.number().numberBetween(100, 200),
                faker.name().firstName(),
                faker.name().lastName(),
                new LinkedList<>()
        );

        Book book = new Book(faker.number().numberBetween(200, 300), faker.book().title(), faker.book().author());
        Volume volume = new Volume(faker.number().numberBetween(300, 400), book);

        // When
        callSlipService.saveBorrow(volume, reader);

        // Then
        var callSlips = callSlipService.getAll()
                .stream()
                .filter(callSlip1 -> callSlip1.getVolume().equals(volume))
                .toList();

        assertEquals(1, callSlips.size());
        assertEquals(callSlips.get(0).getVolume().getId(), volume.getId());
        assertEquals(callSlips.get(0).getReader().getId(), reader.getId());
    }

    @Test
    public void shouldReturnTrueWhenVolumeIsBorrowed() {
        // Given
        Reader reader = new Reader(faker.number().numberBetween(100, 200), faker.name().firstName(), faker.name().lastName(), new LinkedList<>());
        Book book = new Book(faker.number().numberBetween(200, 300), faker.book().title(), faker.book().author());
        Volume volume = new Volume(faker.number().numberBetween(300, 400), book);

        // When
        callSlipService.saveBorrow(volume, reader);

        // Then
        assertTrue(callSlipService.isVolumeBorrowed(volume.getId()));
    }

    @Test
    public void shouldReturnFalseWhenVolumeIsNotBorrowed() {
        // Given
        Book book = new Book(faker.number().numberBetween(200, 300), faker.book().title(), faker.book().author());
        Volume volume = new Volume(faker.number().numberBetween(300, 400), book);

        // Then
        assertFalse(callSlipService.isVolumeBorrowed(volume.getId()));
    }
}