package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HorseRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("insert the length of the race(in feet): ");
        int raceLength = scanner.nextInt();

        System.out.println("How many horses are in the race?");
        int numberOfHorses = scanner.nextInt();
        scanner.nextLine(); 

        List<Thread> horses = new ArrayList<>();

        for (int i = 0; i < numberOfHorses; i++) {
            System.out.println("Insert the name of the horse " + (i + 1) + ":");
            String horseName = scanner.nextLine();
            Horse horse = new Horse(horseName, raceLength);
            Thread horseThread = new Thread(horse);
            horses.add(horseThread);
        }

        System.out.println("The race is about to start!");

        for (Thread horseThread : horses) {
            horseThread.start();
        }

        for (Thread horseThread : horses) {
            try {
                horseThread.join();
            } catch (InterruptedException e) {
                System.out.println("The race was interrupted.");
            }
        }

        System.out.println("The race is over! The winner is: " + horses.get(0).getName());
        scanner.close();
    }
}
