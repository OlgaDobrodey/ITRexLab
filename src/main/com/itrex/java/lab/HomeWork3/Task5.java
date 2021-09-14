package main.com.itrex.java.lab.HomeWork3;

import java.util.stream.LongStream;

/**
 * Write a method for calculating the sum of
 * odd numbers in the given interval (inclusively) using Stream API.
 * <p>
 * Important. Use the provided template for your method.
 * Pay attention to type of an argument and the returned value. Please, don't use cycles.
 * <p>
 * Sample Input 1:
 * 0 0
 * <p>
 * Sample Output 1:
 * 0
 * <p>
 * Sample Input 2:
 * 7 9
 * <p>
 * Sample Output 2:
 * 16
 * <p>
 * Sample Input 3:
 * 21 30
 * <p>
 * Sample Output 3:
 * 125
 */
public class Task5 {

    /**
     * The method calculates the sum of odd numbers in the given range
     *
     * @param start of a range, start >= 0
     * @param end   of a range (inclusive), end >= start
     * @return sum of odd numbers
     */
    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed( start, end ).filter((x)->x%2==1).sum();
    }
}
