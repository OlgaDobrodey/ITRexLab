package com.itrex.java.lab.HomeWork5;

/*
Thread C: calls landrover() that should output the word "LandRover".
 */
public class ThreadC extends Thread {

    private final LandRover rover;

    public ThreadC(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (Flag.flag) {
            try {
                rover.landrover(() -> System.out.print("LandRover"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
