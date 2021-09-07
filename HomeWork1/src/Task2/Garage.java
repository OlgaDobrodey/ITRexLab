package Task2;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/*
Создать класс Garage, хранящий в себе HashMap автомобилей,
в котором ключом является объект автомобиля, значением - количество точно таких автомобилей в гараже.
Добавить в класс Garage методы для парковки, выезда авто, а также для получения количества определенного вида автомобилей.
 */
public class Garage {
    public static Map<Car, Integer> cars = new HashMap<>();

    public static Integer addCar(Car car) {
        System.out.println(car.toString()+"  заехала на парковку");
        return cars.merge(car, 1, (a, b) -> cars.get(car) + 1);
    }

    public static Integer removeCar(Car car) {
        Integer count;
        if (cars.containsKey(car)) {
            count = cars.get(car) - 1;
            if (count == 0) {
                System.out.println("последняя машина данного вида покинула гараж");
                return cars.remove(car);
            } else {
                System.out.println("Одна машина вида " + car.toString() + " выехала");
                return cars.put(car, count);
            }
        } else {
            System.out.println(car.toString()+ " машины такого вида не было в гараже");
            return -1;
        }
    }

    public static Integer countThisCar(Car car) {
        return cars.get(car);
    }


}
