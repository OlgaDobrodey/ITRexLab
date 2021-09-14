package main.com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;


class Task2Test {

    private final String text = "Carol felt tired. She felt tired all the time." +
            " She didn't use to feel tired. 111 She used to have a lot of energy." +
            " Why was she so tired all the time? \"You should eat more sugar,\"" +
            " her friend told her. \"Sugar will give you energy.\" " +
            "But Carol didn't want to eat more sugar. More sugar would give her more weight.";

    private final List<String> badWord = List.of("felt", "She", "time", "mama", "111");

    @Test
    void createBadWordsDetectingStreamTest() {
        assertLinesMatch(Task2.createBadWordsDetectingStream(text, badWord), Stream.of("111", "She", "felt", "time"));
    }

    @Test
    void createBadWordsDetectingStreamNullTextTest() {
        assertLinesMatch(Task2.createBadWordsDetectingStream(null, badWord), Stream.of());
    }

    @Test
    void createBadWordsDetectingStreamNullBadWordsTest() {
        assertLinesMatch(Task2.createBadWordsDetectingStream(text,null), Stream.of());
    }

    @Test
    void createBadWordsDetectingStreamNullAllTest() {
        assertLinesMatch(Task2.createBadWordsDetectingStream(null,null), Stream.of());
    }

    @Test
    void createBadWordsDetectingStreamNoMatchesTest(){
        assertLinesMatch(Task2.createBadWordsDetectingStream(text,List.of("мама", "мыла","раму")),Stream.of());
    }

}