package main.com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task1Test {

    @Test
    void isPrimeTrueTest() {
        assertTrue(Task1.isPrime(2));
    }

    @Test
    void isPrimeFalseTest() {
        assertFalse(Task1.isPrime(4));
    }

}