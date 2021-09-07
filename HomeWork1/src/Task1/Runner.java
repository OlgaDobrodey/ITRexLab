package Task1;

/*
1. Задан текст на английском языке. Выделить все различные слова.
Для каждого слова подсчитать частоту его встречаемости.
Слова, отличающиеся регистром букв, считать различными.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Runner {

    private static String FILE_NAME = "text.txt";

    public static void main(String[] args) throws IOException {
        String collect = Files.lines(Paths.get("HomeWork1/src/Task1/text.txt")).collect(Collectors.joining());
        System.out.println(collect);
        String[] array = collect.split("[^a-zA-Z]+");
        Map<String,Integer> map= new HashMap<>();
        for (String s : array) {
            map.merge(s, 1, (a, b) -> map.get(s) + 1);
        }

        map.forEach( (a, b) -> System.out.println(a+":" +b));


    }
    }




