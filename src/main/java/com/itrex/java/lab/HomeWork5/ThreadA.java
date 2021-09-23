package com.itrex.java.lab.HomeWork5;

/*
Thread A: calls land() that should output the word "Land"
 */
public class ThreadA extends Thread {

    private final LandRover rover;

    public ThreadA(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        try {
            rover.land(() -> System.out.print("Land"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


