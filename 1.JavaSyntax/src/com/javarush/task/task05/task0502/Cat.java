package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }
    public Cat(String name, int age, int weight, int strength){
    }

    public boolean fight(Cat anotherCat) {
        if (this.strength > anotherCat.strength)
            return true;
        else return false;



    }

    public static void main(String[] args) {
        Cat cat = new Cat("Vaksa", 7,1,11);
        Cat cat1 = new Cat("barsik", 4, 11, 13);
        cat.fight(cat1);
    }
}
