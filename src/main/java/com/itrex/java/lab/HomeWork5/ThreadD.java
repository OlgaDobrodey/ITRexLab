package com.itrex.java.lab.HomeWork5;

public class ThreadD extends Thread {

    private final LandRover rover;

    public ThreadD(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LandRover.monitor) {
                if (rover.getCount() <= rover.getN()) {
                    try {
                        rover.number(value -> System.out.println(value));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }

}
