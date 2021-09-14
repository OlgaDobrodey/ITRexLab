package main.com.itrex.java.lab.HomeWork3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task7Test {

    Transaction transaction1;
    Transaction transaction2;
    Transaction transaction3;
    Account account1;
    Account account2;
    Account account3;

    @BeforeEach
    void creatEntites() {
        transaction1 = new Transaction(State.CANCELED, 1000L);
        transaction2 = new Transaction(State.FINISHED, 8000L);
        transaction3 = new Transaction(State.CANCELED, 10000L);
        account1 = new Account(0L, List.of(transaction1));
        account2 = new Account(8000L, List.of(transaction2, transaction3));
        account3 = new Account(8000L, List.of(transaction1, transaction2));
    }

    @Test
    void calcSumOfCanceledTransOnNonEmptyAccountsTest() {
        long expected = Task7.calcSumOfCanceledTransOnNonEmptyAccounts(List.of(account1, account2, account3));
        assertEquals(expected, 11000);
    }

    @Test
    void calcSumOfCanceledTransOnEmptyAccountsTest() {
        long expected = Task7.calcSumOfCanceledTransOnNonEmptyAccounts(List.of(account1));
        assertEquals(expected, 0);
    }

    @Test
    void calcSumOfCanceledTransOnNullAccountsTest() {
        long expected = Task7.calcSumOfCanceledTransOnNonEmptyAccounts(null);
        assertEquals(expected, -1);
    }

}