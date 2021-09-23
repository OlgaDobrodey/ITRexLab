package com.itrex.java.lab.HomeWork5;

/*
Thread D: calls number() that should only output the integers.
 */
public class ThreadD extends Thread {

    private final LandRover rover;

    public ThreadD(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        try {
            rover.number(value -> System.out.print(value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
