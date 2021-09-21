package com.itrex.java.lab.HomeWork5;

public class ThreadA extends Thread {

    private final LandRover rover;

    public ThreadA(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (Flag.flag) {
            try {
                rover.land(() -> System.out.print("Land"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


