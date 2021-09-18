package com.itrex.java.lab.HomeWork4;

import java.util.function.Function;

/**
 * <p>
 * Write a curried form of the function f(x,y,z)=x+y∗y+z∗z∗z using lambda expressions in Java >8 style.
 * The result and x, y, z must be integer numbers.
 * <p>
 * Write a curried function (using lambdas) that accepts four string arguments and concatenated all in one string
 * following the rules:
 * String cases: in the result string, first and second arguments must be in lower cases and third and fourth in
 * upper cases.
 * Order of arguments concatenation: first, third, second, fourth.
 */
public class Task6 {

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function1 = x -> y -> z -> x + y * y + z * z * z;

        Function<String, Function<String, Function<String, Function<String, String>>>> function2 = a -> b -> c -> d -> new StringBuilder(a.toLowerCase())
                .append(c.toUpperCase())
                .append(b.toLowerCase())
                .append(d.toUpperCase())
                .toString();

        String apply = function2.apply("Olga").apply("lena").apply("sasa").apply("we");
        System.out.println(apply);
        Integer apply1 = function1.apply(1).apply(2).apply(3);
        System.out.println(apply1);



    }
}
