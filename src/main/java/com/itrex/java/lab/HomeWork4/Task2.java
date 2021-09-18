package com.itrex.java.lab.HomeWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * Write the disjunctAll method that accepts a list of
 * IntPredicate's and returns a single IntPredicate.
 * The result predicate is a disjunction of all input predicates.
 * <p>
 * If the input list is empty then the result predicate should
 * return false for any integer value (always false).
 */
public class Task2 {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        return predicates.stream()
                .reduce(i -> false, IntPredicate::or);
    }

    public static void main(String[] args) {
        IntPredicate predicate1 = x -> x!=2;
        IntPredicate predicate2 = x -> x!=4;
        IntPredicate predicate3 = x -> x!=5;
        List<IntPredicate> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        System.out.println(disjunctAll(List.of(predicate1,predicate2,predicate3)).test(2));
        System.out.println(disjunctAll(list).test(2));
        System.out.println(list.isEmpty());

    }

}
