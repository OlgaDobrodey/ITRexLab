package com.itrex.java.lab.HomeWork5;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 50; i++) {
            LandRover rover = new LandRover(i); //1 <= n <= 50

            Thread threadA = new ThreadA(rover); //"Land" if i is divisible by 3 and not 5,
            Thread threadB = new ThreadB(rover); //"Rover" if i is divisible by 5 and not 3
            Thread threadC = new ThreadC(rover); //"LandRover" if i is divisible by 3 and 5,
            Thread threadD = new ThreadD(rover); //i if i is not divisible by 3 or 5

            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();

            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        }
    }

}
