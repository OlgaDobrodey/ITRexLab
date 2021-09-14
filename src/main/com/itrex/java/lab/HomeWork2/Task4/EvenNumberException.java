package main.com.itrex.java.lab.HomeWork2.Task4;

import java.util.List;

/*
Ошибка должна содержать поле с самим листом и поле со значением которое не прошло валидацию.
Эту ошибку из валидатора нужно пробросить на верх.
 */
public class EvenNumberException extends Exception {

    private final List<Integer> list;
    private final Integer value;


    EvenNumberException(String message, List<Integer> list, Integer value) {
        super(message);
        this.list = list;
        this.value = value;
    }

    public List<Integer> getList() {      // исследуемый лист
        return list;
    }

    public Integer getValue() {      // значение, которое не прошло валидацию
        return value;
    }
}
