package com.itrex.java.lab.HomeWork5;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LandRover rover = new LandRover(10); //1 <= n <= 50

        Thread threadA = new Thread(rover,"thread-a"); //"Land" if i is divisible by 3 and not 5,
        Thread threadB = new Thread(rover,"thread-b"); //"Rover" if i is divisible by 5 and not 3
        Thread threadC = new Thread(rover,"thread-c"); //"LandRover" if i is divisible by 3 and 5,
        Thread threadD = new Thread(rover,"thread-d"); //i if i is not divisible by 3 or 5

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

}
