package com.itrex.java.lab.HomeWork1.Task1;

/*
1. Задан текст на английском языке. Выделить все различные слова.
Для каждого слова подсчитать частоту его встречаемости.
Слова, отличающиеся регистром букв, считать различными.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Runner {

    private static String FILE_NAME = "text.txt"; // файл с текстом

    public static void main(String[] args) throws IOException {

        String path = CreatePath.getPath(Runner.class) + FILE_NAME;  //путь к файлу
        Map<String, Integer> map = new TreeMap<>();
        String[] array = Files.lines(Paths.get(path))     //массив слов, 111- не слово, B1 - слово
                .collect(Collectors.joining(" "))
                .replaceAll("[^a-zA-Z]\\d+[^a-zA-Z]", " ")
                .split("[^a-zA-Z0-9’']+");
        Arrays.stream(array).forEach(s -> map.merge(s, 1, (a, b) -> map.get(s) + 1));  //считаем слова
        map.forEach((a, b) -> System.out.println(a + " - встретилось раз - " + b)); // выводим результат
    }

}




