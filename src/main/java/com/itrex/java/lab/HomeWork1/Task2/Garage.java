package com.itrex.java.lab.HomeWork1.Task2;

import java.util.HashMap;
import java.util.Map;

/*
Создать класс Garage, хранящий в себе HashMap автомобилей,
в котором ключом является объект автомобиля, значением - количество точно таких автомобилей в гараже.
Добавить в класс Garage методы для парковки, выезда авто, а также для получения количества определенного вида автомобилей.
 */
public class Garage {

    private Garage() {
    }

    private final static Garage instance = new Garage();

    private final Map<Car, Integer> cars = new HashMap<>();

    public static Garage getInstance() {
        return instance;
    }

    public Map<Car, Integer> getCars() {
        return cars;
    }

    // метод добавления машины на парковку
    public Integer addCar(Car car) {
        System.out.println(car.toString() + "  припоркавалась");
        return cars.merge(car, 1, (a, b) -> cars.get(car) + 1);
    }

    // метод выезда машины с парковку
    public Integer removeCar(Car car) {
        Integer count;
        if (cars.containsKey(car)) {
            count = cars.get(car) - 1;
            if (count == 0) {
                System.out.println("Последняя машина вида " + car.toString() + " покинула гараж");
                return cars.remove(car);
            } else {
                System.out.println("Машина вида " + car.toString() + " выехала из гаража");
                return cars.put(car, count);
            }
        } else {
            System.out.println(car.toString() + "- машина такого вида не было в гараже");
            return -1;
        }
    }

    // метод для получения количества определенного одинаковых автомобилей
    public Integer countThisCar(Car car) {
        return cars.get(car);
    }

    // метод для получения количества определенного вида автомобилей
    public Integer countTypeCar(Car car) {
        int count = 0;
        for (Map.Entry<Car, Integer> carIntegerEntry : cars.entrySet()) {
            if (car.getClass().equals(carIntegerEntry.getKey().getClass())) {
                count = count + carIntegerEntry.getValue();
            }
        }
        return count;
    }
}
