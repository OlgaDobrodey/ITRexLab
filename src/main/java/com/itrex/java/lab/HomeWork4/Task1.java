package com.itrex.java.lab.HomeWork4;

/**
 * You need to write your own functional interface (TernaryIntPredicate) and use it with a
 * lambda expression.
 * The interface must have a single non-static (and non-default) method test with
 * three int arguments that returns boolean value.
 * Besides, you need to write a lambda expression with three int arguments using your
 * TernaryIntPredicate.
 * <p>
 * The lambda expression has to return true if all passed values are different otherwise false. The name of the instance is allValuesAreDifferentPredicate. It should be a static field.
 * <p>
 * Sample Input 1:
 * 1 1 1
 * <p>
 * Sample Output 1:
 * False
 * <p>
 * Sample Input 2:
 * 2 3 4
 * <p>
 * Sample Output 2:
 * True
 */
public class Task1 {

    public static void main(String[] args) {
        TernaryIntPredicate<Integer> predicate = ((a, b, c) -> (a != b && a != c && b != c));
        System.out.println(predicate.allValuesAreDifferentPredicate(1, 1, 1));
        System.out.println(predicate.allValuesAreDifferentPredicate(2, 3, 4));
        System.out.println(predicate.allValuesAreDifferentPredicate(2, 2, 4));
    }
}

@FunctionalInterface
interface TernaryIntPredicate<Integer> {
    Boolean allValuesAreDifferentPredicate(int a, int b, int c);
}
