package com.itrex.java.lab.HomeWork5;

import java.util.function.IntConsumer;

public class LandRover extends TaskConcurrency {


    private volatile int count;
    private final int n;
    public final static Integer monitor = 0;
    private final static Integer monitor2 = 0;

    public LandRover(int n) {
        super(n);
        this.n = n;
        this.count = 1;
    }

    @Override
    public void land(Runnable printLand) throws InterruptedException {
            if (count % 3 == 0 && count % 5 != 0) {
                printLand.run();
                this.count++;
            }
    }

    @Override
    public void rover(Runnable printRover) throws InterruptedException {
            if (count % 3 != 0 && count % 5 == 0) {
                printRover.run();
                this.count++;
            }
    }

    @Override
    public void landrover(Runnable printLandRover) throws InterruptedException {
            if (count % 3 == 0 && count % 5 == 0) {
                printLandRover.run();
                this.count++;
            }
    }

    @Override
    public void number(IntConsumer printNumber) throws InterruptedException {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                this.count++;
            }
    }

    public int getCount() {
        synchronized (monitor2) {
            return count;
        }
    }

    public int getN() {
        return n;
    }

}
