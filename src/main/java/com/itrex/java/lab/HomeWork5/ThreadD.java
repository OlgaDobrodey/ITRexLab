package com.itrex.java.lab.HomeWork5;

public class ThreadD extends Thread {

    private final LandRover rover;

    public ThreadD(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (Flag.flag) {
            try {
                rover.number(value -> System.out.print(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
