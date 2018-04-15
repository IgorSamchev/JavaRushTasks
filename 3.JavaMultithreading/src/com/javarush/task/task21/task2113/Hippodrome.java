package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        ArrayList<Horse> horseList = new ArrayList<>();
        Horse horse1 = new Horse("Jana", 3, 0);
        Horse horse2 = new Horse("PaPa", 3, 0);
        Horse horse3 = new Horse("Mama", 3, 0);
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();

    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
            print();
        }

    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }

    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        double maxDistance = horses.get(0).getDistance();
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }




}
