package com.github.mako321.Services;

import com.github.mako321.Models.CallSlip;
import com.github.mako321.Models.Item;
import com.github.mako321.Models.Reader;
import com.github.mako321.Models.Volume;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ReaderServiceTest {

    private ReaderService readerService;
    private Faker faker;

    @BeforeEach
    public void setUp() {
        readerService = new ReaderService();
        faker = new Faker();
    }

    @Test
    public void shouldFindReaderByIdWhenExists() {
        var readerId = faker.number().numberBetween(1, 100);
        var reader = new Reader(
                readerId,
                faker.name().firstName(),
                faker.name().lastName(),
                new LinkedList<>()
        );

        readerService.save(reader);

        // when
        var result = readerService.findReaderById(readerId);

        //then
        assertTrue(result.isPresent()); // czy znaleziono czytelnika?
        assertEquals(readerId, result.get().getId().intValue()); // czy zgadza się identyfikator?
        assertEquals(0, result.get().getCallSlips().size()); // czy lista wypożyczeń jest pusta?
    }

    @Test
    public void shouldNotFindReaderByIdWhenNotExists() {
        var result = readerService.findReaderById(1234);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenMaxBorrowLimitIsReached() {
        // given
        var readerId = faker.number().numberBetween(1, 100);
        var reader = new Reader(
                readerId,
                faker.name().firstName(),
                faker.name().lastName(),
                new LinkedList<>()
        );

        List<CallSlip> callSlips = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var volume = new Volume(
                    faker.number().numberBetween(200, 300),
                    new Item(faker.number().numberBetween(200, 300), faker.book().title())
            );
            callSlips.add(new CallSlip(volume, reader));
        }
        reader.getCallSlips().addAll(callSlips);

        // When
        var result = readerService.isMaxBorrowLimitReached(reader);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenMaxBorrowLimitIsNotReached() {
        // given
        var readerId = faker.number().numberBetween(1, 100);
        var reader = new Reader(
                readerId,
                faker.name().firstName(),
                faker.name().lastName(),
                new LinkedList<>()
        );

        // When
        var result = readerService.isMaxBorrowLimitReached(reader);

        // then
        assertFalse(result);
    }
}