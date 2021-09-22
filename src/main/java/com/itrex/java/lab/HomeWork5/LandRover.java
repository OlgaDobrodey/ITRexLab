package com.itrex.java.lab.HomeWork5;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class LandRover implements Runnable {

    private volatile int count;
    private final int n;
    private Semaphore semaphore = new Semaphore(1);

    private Runnable printLand = () -> System.out.print("Land");
    private Runnable printRover = () -> System.out.print("Rover");
    private Runnable printLandRover = () -> System.out.print("LandRover");
    private IntConsumer printNumber = value -> System.out.print(value);

    public LandRover(int n) {   //1 <= n <= 50
        if (n < 1 || n > 50) {
            throw new IllegalArgumentException("invalid t value n");
        }
        this.n = n;
        this.count = 1;
    }

    static {
        System.out.print("[");
    }

    public void land(Runnable printLand) throws InterruptedException {
        synchronized (this) {
            if (count <= n && count % 3 == 0 && count % 5 != 0) {
                printLand.run();
                printСorrect(count);
                count++;
            }
        }
    }

    public void rover(Runnable printRover) throws InterruptedException {
        synchronized (this) {
            if (count <= n && count % 3 != 0 && count % 5 == 0) {
                printRover.run();
                printСorrect(count);
                count++;
            }
        }
    }

    public void landrover(Runnable printLandRover) throws InterruptedException {
        synchronized (this) {
            if (count <= n && count % 3 == 0 && count % 5 == 0) {
                printLandRover.run();
                printСorrect(count);
                count++;
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            if (count <= n && count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                printСorrect(count);
                count++;
            }
        }
    }

    //method correct print to view ["land",2,3]
    private void printСorrect(int count) {
        if (count == n) {
            System.out.println("]");
        } else {
            System.out.print(",");
        }
    }

    @Override
    public void run() {
        while (count <= n) {
            try {
                semaphore.acquire();
                if (Thread.currentThread().getName().equals("thread-a")) {
                    land(printLand);
                } else if (Thread.currentThread().getName().equals("thread-b")) {
                    rover(printRover);
                } else if (Thread.currentThread().getName().equals("thread-c")) {
                    landrover(printLandRover);
                } else {
                    number(printNumber);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}

