package com.itrex.java.lab.HomeWork2.Task4;

import java.util.List;

/*
Выше уровнем ошибку нужно поймать, залогировать и запустить всю логику заново.
(программа должна работать пока не сгенерит валидный лист).
 */
public class Main {
    public static void main(String[] args) {

        Generator generator = new Generator();
        List<Integer> list = generator.generateRandomList(3);
        while (true) {
            try {
               if(Validator.validatorList(list)){break;}
            } catch (EvenNumberException ex) {
                Logger.getLogger().log(ex.getMessage(),ex.getList(),ex.getValue());
                list = generator.generateRandomList(3);

            }
        }
        System.out.println("The result:");
        System.out.println("list: "+list);
    }

}
