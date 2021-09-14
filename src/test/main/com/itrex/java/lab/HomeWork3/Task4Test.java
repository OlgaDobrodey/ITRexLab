package main.com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4Test {

    @Test
    void factorialTestForZeroTest() {
        assertEquals(Task4.factorial(0L), 1L);
    }

    @Test
    void factorialTestForOneTest() {
        assertEquals(Task4.factorial(1L), 1L);
    }

    @Test
    void factorialTestForThreeTest() {
        assertEquals(Task4.factorial(3L), 6L);
    }

}