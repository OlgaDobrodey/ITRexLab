package com.itrex.java.lab.HomeWork5;

public class ThreadA extends Thread {

    private LandRover rover;

    public ThreadA(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LandRover.monitor) {
                if (rover.getCount() <= rover.getN()) {
                    try {
                        rover.land(() -> System.out.println("Land"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }

    }
}


