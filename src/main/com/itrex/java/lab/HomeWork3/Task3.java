package main.com.itrex.java.lab.HomeWork3;

import java.util.stream.IntStream;

/**
 * You have two IntStream. The first stream contains even numbers and the second stream contains odd numbers.
 * Create the third stream that contains numbers from both streams which is divisible by 3 and 5.
 * After calling collect(Collectors.toList()) the stream should return sorted list (ascending) of these numbers. Two first suitable numbers in the sorted list must be skipped.
 * <p>
 * Important. You need return a prepared IntStream from a template method,
 * not a list of integers. Pay attention to the method template. Do not change the signature of this method.
 * <p>
 * Sample Input 1:
 * 1 2 3 4
 * <p>
 * Sample Output 1:
 * []
 * <p>
 * Sample Input 2:
 * 30 75 60 90
 * <p>
 * Sample Output 2:
 * [75, 90]
 */
public class Task3 {

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream).filter((x)-> x%3==0 && x%5==0).sorted().skip(2);
    }
}
