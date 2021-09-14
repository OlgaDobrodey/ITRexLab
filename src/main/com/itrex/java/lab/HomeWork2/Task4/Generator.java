package main.com.itrex.java.lab.HomeWork2.Task4;

/*
Написать генератор листа рандомных чисел от 1 до 9, лист должен содержать 3 элемента.
 */

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public List<Integer> generateRandomList(Integer size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 9) + 1);
        }
        return list;
    }

}
