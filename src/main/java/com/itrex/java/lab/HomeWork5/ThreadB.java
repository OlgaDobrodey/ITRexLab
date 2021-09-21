package com.itrex.java.lab.HomeWork5;

public class ThreadB extends Thread {

    private LandRover rover;

    public ThreadB(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (Flag.flag) {
            try {
                rover.rover(() -> System.out.print("Rover"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
