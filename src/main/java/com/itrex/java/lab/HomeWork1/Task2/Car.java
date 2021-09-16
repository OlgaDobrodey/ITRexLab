package com.itrex.java.lab.HomeWork1.Task2;

import java.util.Objects;

public abstract class Car{
    // марка, модель, год выпуска + несколько своих.
    private String kind;  //марка
    private String model; //модель
    private int year;     //год выпуска
    private String color; // цвет
    private int maxSpeed; // максимальная скорость

    public Car(String kind, String model, int year, String color, int maxSpeed) {
        this.kind = kind;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && maxSpeed == car.maxSpeed && kind.equals(car.kind) && model.equals(car.model) && color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, model, year, color, maxSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "kind='" + kind + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
