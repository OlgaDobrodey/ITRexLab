package com.itrex.java.lab.HomeWork5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FlagTest {

    @Test
    void getFlagFalseTest() {
        Flag.getFlagFalse();
        assertFalse(Flag.flag);
    }
}