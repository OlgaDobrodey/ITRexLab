package com.itrex.java.lab.HomeWork1.Task2;

public class Ford extends Car{

    public Ford(String kind, String model, int year, String color, int maxSpeed) {
        super(kind, model, year, color, maxSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ford car = (Ford) o;
        return  getYear() == car.getYear() && getMaxSpeed() == car.getMaxSpeed()
                && getKind().equals(car.getKind()) && getModel().equals(car.getModel()) && getColor().equals(car.getColor());

    }

    @Override
    public int hashCode() {
        return 39*super.hashCode();
    }
    @Override
    public String toString() {
        return "Ford {"+getKind()+", "+ getModel()+", " +getYear()+", "+getColor()+", " +getMaxSpeed()+'}';
    }
}
