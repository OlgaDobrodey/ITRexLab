package com.itrex.java.lab.HomeWork5;

import java.util.function.IntConsumer;

public class TaskConcurrency {
    private int n;

    public TaskConcurrency(int n) {
        this.n = n;
    }

    // printLand.run() outputs "land".
    public void land(Runnable printLand) throws InterruptedException {

    }

    // printRover.run() outputs "rover".
    public void rover(Runnable printRover) throws InterruptedException {

    }

    // printLandRover.run() outputs "landrover".
    public void landrover(Runnable printLandRover) throws InterruptedException {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

    }
}
