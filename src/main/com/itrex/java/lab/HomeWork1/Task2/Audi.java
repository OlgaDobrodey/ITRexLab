package main.com.itrex.java.lab.HomeWork1.Task2;

public class Audi extends Car{

    public Audi(String kind, String model, int year, String color, int maxSpeed) {
        super(kind, model, year, color, maxSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audi car = (Audi) o;
        return  getYear() == car.getYear() && getMaxSpeed() == car.getMaxSpeed()
                && getKind().equals(car.getKind()) && getModel().equals(car.getModel()) && getColor().equals(car.getColor());

    }

    @Override
    public int hashCode() {
        return 31*super.hashCode();
    }

    @Override
    public String toString() {
        return "Audi {"+getKind()+", "+ getModel()+", " +getYear()+", "+getColor()+", " +getMaxSpeed()+'}';
    }
}
