package com.itrex.java.lab.HomeWork5;

import java.util.function.IntConsumer;

public class LandRover extends TaskConcurrency {

    private volatile int count;
    private final int n;
    private final static Integer monitor = 0;

    public LandRover(int n) {
        super(n);                       //1 <= n <= 50
        if (n < 1 || n > 50) {
            throw new IllegalArgumentException("invalid t value n");
        }
        this.n = n;
        this.count = 1;;
    }

    static {
        System.out.print("[");
    }

    @Override
    public void land(Runnable printLand) throws InterruptedException {
        synchronized (monitor) {
            if (count % 3 == 0 && count % 5 != 0) {
                printLand.run();
                printСorrect(count);
                setCount(count);
            }
        }
    }

    @Override
    public void rover(Runnable printRover) throws InterruptedException {
        synchronized (monitor) {
            if (count % 3 != 0 && count % 5 == 0) {
                printRover.run();
                printСorrect(count);
                setCount(count);
            }
        }
    }

    @Override
    public void landrover(Runnable printLandRover) throws InterruptedException {
        synchronized (monitor) {
            if (count % 3 == 0 && count % 5 == 0) {
                printLandRover.run();
                printСorrect(count);
                setCount(count);
            }
        }
    }

    @Override
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (monitor) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                printСorrect(count);
                setCount(count);
            }
        }
    }

    //method set count and if count = n stops threads
    private void setCount(int count) {
        if ((count + 1) > n) {
            Flag.getFlagFalse();
            this.count = count;
        } else this.count = count + 1;
    }

    //method correct print to view ["land",2,3]
    private void printСorrect(int count) {
        if ((count + 1) > n) {
            System.out.println("]");
        } else {
            System.out.print(",");
        }
    }
}