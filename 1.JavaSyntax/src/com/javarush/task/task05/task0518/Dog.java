package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/


public class Dog {
    private String name;
    private int height;
    private String color;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public Dog(String name, int height) {

        this.name = name;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
