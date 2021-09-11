package Task4;

import java.util.List;

/*
Написать валидатор этого листа который проверяет все ли значения этого листа не четные.
Если лист содержит четное число/числа валидатор бросает Вашу собственную ошибку(её нужно написать).
Ошибка должна содержать поле с самим листом и поле со значением которое не прошло валидацию.
Эту ошибку из валидатора нужно пробросить на верх.
 */
public class Validator {

    public static Boolean validatorList (List <Integer> list) throws EvenNumberException {
        for (Integer integer : list) {
            if(integer%2==0){
                throw new EvenNumberException("List is contained even element",list,integer);
            }
        }
        return true;
    }
}
