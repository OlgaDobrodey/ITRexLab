package main.com.itrex.java.lab.HomeWork1.Task2;

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

        //  создание автомобилей разного вида
        Car audi = new Audi("audi", "model", 123, "red", 300);
        Car audi2 = new Audi("audi", "model", 123, "red", 3);
        Car bmw = new Bmw("audi", "model", 123, "red", 300);
        Car ford = new Ford("ford", "model", 123, "red", 300);
        Car honda = new Honda("honda", "model", 123, "red", 300);

        Garage garage = Garage.getInstance();

        // на парковку въехали 3 одинаковые audi, 1 - audi2, 1 - bmw, 1 - ford, 2 - honda
        garage.addCar(audi);
        garage.addCar(audi);
        garage.addCar(audi);
        garage.addCar(audi2);
        garage.addCar(bmw);
        garage.addCar(ford);
        garage.addCar(honda);
        garage.addCar(honda);

        System.out.println("Состояние машин в гараже:");
        garage.getCars().forEach((key,value)->{System.out.println(" ".repeat(10)+key + "=" + value + " ");}  );

        //количество машин одинаковых машин
        System.out.println("Машин вида audi - "+garage.countThisCar(audi));

        // машины выезжают 1 - audi, 1 - ford, 1 - honda
        garage.removeCar(honda);
        garage.removeCar(ford);
        garage.removeCar(audi);
        System.out.println("Состояние машин в гараже:");
        garage.getCars().forEach((key,value)->{System.out.println(" ".repeat(10)+key + "=" + value + " ");}  );

        System.out.println("Количество автомобилей вида audi - "+garage.countTypeCar(audi));
        System.out.println("Количество автомобилей вида ford - "+garage.countTypeCar(ford));
        System.out.println("Количество автомобилей вида bmw - "+garage.countTypeCar(bmw));
    }
}
