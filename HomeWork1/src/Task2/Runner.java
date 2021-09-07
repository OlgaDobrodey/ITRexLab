package Task2;

import java.sql.SQLOutput;

/*
2. Создать абстрактный класс Car, представляющий собой автомобиль.
Добавить в него поля: марка, модель, год выпуска + несколько своих.
Создать 4 класса, являющихся наследниками Car.
Переопределить во всех 4-х классах методы equals(), hashCode() и toString()
Создать класс Garage, хранящий в себе HashMap автомобилей,
в котором ключом является объект автомобиля, значением - количество точно таких автомобилей в гараже.
Добавить в класс Garage методы для парковки, выезда авто, а также для получения количества определенного вида автомобилей.
Продемонстрировать работу гаража
 */
public class Runner {
    public static void main(String[] args) {
        Car audi = new Audi("audi", "model", 123, "red", 300);
        Car audi2 = new Audi("audi", "model", 123, "red", 3);
        Car bmw = new Bmw("audi", "model", 123, "red", 300);
        Car ford = new Ford("ford", "model", 123, "red", 300);
        Car honda = new Honda("honda", "model", 123, "red", 300);

        // первая машина поехала на парковку
        Garage.addCar(audi);
        Garage.cars.forEach((key,value)->{System.out.print(key + "=" + value + " ");}  );
        System.out.println();

        Garage.addCar(audi);
        Garage.cars.forEach((key,value)->{System.out.print(key + "=" + value + " ");}  );
        System.out.println();

        Garage.addCar(audi);
        Garage.addCar(audi2);
        Garage.addCar(bmw);
        Garage.addCar(ford);
        Garage.addCar(honda);
        Garage.addCar(honda);



        Garage.cars.forEach((key,value)->{System.out.print(key + "=" + value + " ");}  );
        System.out.println();

        System.out.println(Garage.countThisCar(audi));

        Garage.removeCar(honda);
        Garage.cars.forEach((key,value)->{System.out.print(key + "=" + value + " ");}  );
        System.out.println();

        Garage.removeCar(honda);
        Garage.cars.forEach((key,value)->{System.out.print(key + "=" + value + " ");}  );
        System.out.println();
        Garage.removeCar(honda);
        Garage.cars.forEach((key,value)->{System.out.print(key + "=" + value + " ");}  );
        System.out.println();

    }
}
