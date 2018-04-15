package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

public class Circle {
    //centerX, centerY, radius, width и color с типом int.
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private int color;

    public static void main(String[] args) {

    }

    public void initialize(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;

    }

    public void initialize(int centerX, int centerY, int radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }

    public void initialize(int centerX, int centerY, int radius, int width, int color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;

    }
}
