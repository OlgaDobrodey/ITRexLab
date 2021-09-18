package com.itrex.java.lab.HomeWork4;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        String john = null;
        Optional<String> name = Optional.ofNullable(john);
        System.out.println(name);
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";


        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(quoteIntToString);
        Integer integer = Arrays.asList(1, 2, 3).stream().reduce((s1, s2) -> s1 + s2).orElse(0);


    }

}
