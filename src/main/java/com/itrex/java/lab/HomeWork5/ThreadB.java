package com.itrex.java.lab.HomeWork5;

public class ThreadB extends Thread {

    private LandRover rover;

    public ThreadB(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (LandRover.monitor) {
                if (rover.getCount() <= rover.getN()) {
                    try {
                        rover.rover(() -> System.out.println("Rover"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }
        }
    }
}
