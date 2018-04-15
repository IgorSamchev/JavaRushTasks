package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int left;
    private int top;
    private int width = 0;
    private int height = 0;

    public Rectangle() {
        left = 1;
        top = 2;
        width = 3;
        height = 4;
    }

    public Rectangle(int left, int top) {
        this.left = left;
        this.top = top;
    }

    public Rectangle(int wigth) {
        this.width = wigth;
        this.height = wigth;
    }

    public Rectangle(int left, int top, int wigth, int height) {
        this.left = left;
        this.top = top;
        this.width = wigth;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
