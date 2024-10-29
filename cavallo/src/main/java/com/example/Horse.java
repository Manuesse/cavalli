package com.example;

import java.util.Random;

public class Horse implements Runnable {
    private final String name;
    private final int raceLength;
    private int distanceCovered = 0;
    private static boolean raceWon = false;

    public Horse(String name, int raceLength) {
        this.name = name;
        this.raceLength = raceLength;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distanceCovered < raceLength && !raceWon) {
            try {
                int step = random.nextInt(10) + 1;
                distanceCovered += step;
                System.out.println(name + " ha percorso finora: " + distanceCovered + " metri");

                if (distanceCovered >= raceLength && !raceWon) {
                    raceWon = true;
                    System.out.println(name + " ha vinto la gara!");
                }

                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(name + " è stato interrotto.");
            }
        }
    }
}
