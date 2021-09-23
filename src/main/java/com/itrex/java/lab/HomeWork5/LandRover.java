package com.itrex.java.lab.HomeWork5;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LandRover extends TaskConcurrency {

    private int count;
    private final int n;

    public LandRover(int n) {
        super(n);                       //1 <= n <= 50
        if (n < 1 || n > 50) {
            throw new IllegalArgumentException("invalid t value n");
        }
        this.n = n;
        this.count = 1;
        ;
    }

    @Override
    public void land(Runnable printLand) throws InterruptedException {
        IntPredicate predicate = (count -> count % 3 == 0 && count % 5 != 0);
        processCall(predicate, printLand, null);
    }

    @Override
    public void rover(Runnable printRover) throws InterruptedException {
        IntPredicate predicate = (count -> count % 3 != 0 && count % 5 == 0);
        processCall(predicate, printRover, null);
    }

    @Override
    public void landrover(Runnable printLandRover) throws InterruptedException {
        IntPredicate predicate = (count -> count % 3 == 0 && count % 5 == 0);
        processCall(predicate, printLandRover, null);
    }

    @Override
    public void number(IntConsumer printNumber) throws InterruptedException {
        IntPredicate predicate = (count -> count % 3 != 0 && count % 5 != 0);
        processCall(predicate, null, printNumber);
    }

    //method correct print to view ["land",2,3]
    private void printСorrect(int count) {
        if ((count + 1) > n) {
            System.out.println("]");
        } else {
            System.out.print(",");
        }
    }

    private void processCall(IntPredicate predicate, Runnable print, IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (count <= n) {
                if (predicate.test(count)) {
                    if (print != null) {
                        print.run();
                    } else {
                        if(count==1) System.out.print("[");
                        printNumber.accept(count);
                    }

                    printСorrect(count);
                    count++;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

}
