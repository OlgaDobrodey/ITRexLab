package com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class Task3Test {

    private final IntStream evenStream = IntStream.of(30, 60, 90);
    private final IntStream oddStream = IntStream.of(75, 23);

    @Test
    void createFilteringStreamTest() {
        assertIterableEquals(Task3.createFilteringStream(evenStream, oddStream).boxed().collect(Collectors.toList()),
                List.of(75, 90));
    }

    @Test
    void createFilteringStreamNullEvenStreamTest() {
        assertIterableEquals(Task3.createFilteringStream(null, oddStream).boxed().collect(Collectors.toList()),
                List.of());
    }

    @Test
    void createFilteringStreamNullOddStreamTest() {
        assertIterableEquals(Task3.createFilteringStream(evenStream, null).boxed().collect(Collectors.toList()),
                List.of());
    }

    @Test
    void createFilteringStreamNullStreamTest() {
        assertIterableEquals(Task3.createFilteringStream(null, null).boxed().collect(Collectors.toList()),
                List.of());
    }

    @Test
    void createFilteringStreamNoMatchesTest() {
        assertIterableEquals(Task3.createFilteringStream(evenStream.skip(2), oddStream).boxed().collect(Collectors.toList()),
                List.of());
    }

}