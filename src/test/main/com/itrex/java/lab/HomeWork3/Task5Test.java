package main.com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @Test
    void sumOfOddNumbersInRangeTest() {
        assertEquals(Task5.sumOfOddNumbersInRange(7, 9), 16);
    }

    @Test
    void sumOfOddNumbersInRangeNegativNumberTest() {
        assertEquals(Task5.sumOfOddNumbersInRange(-21, 30), -1);
    }

    @Test
    void sumOfOddNumbersInRangeWrongSpacingTest() {
        assertEquals(Task5.sumOfOddNumbersInRange(21, -30), -1);
    }

    @Test
    void sumOfOddNumbersInRangeNumberIsEmptyTest() {
        assertEquals(Task5.sumOfOddNumbersInRange(0, 0), 0);
    }

}