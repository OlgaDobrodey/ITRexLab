package com.itrex.java.lab.HomeWork5;

public class ThreadC extends Thread {

    private LandRover rover;

    public ThreadC(LandRover rover) {
        this.rover = rover;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LandRover.monitor) {
                if (rover.getCount() <= rover.getN()) {
                    try {
//                Monitors.monitorThreadC.wait();
                        rover.landrover(() -> System.out.println("LandRover"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }

        }
    }

}
