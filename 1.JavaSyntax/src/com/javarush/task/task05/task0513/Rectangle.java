package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //top, left, width, height
    private int top;
    private int left;
    private int width = 0;
    private int height = 0;

    public void initialize(){
        top = 1;
        left = 2;
        width = 3;
        height = 4;
    }

    public void  initialize(int top, int left){
        this.left = left;
        this.top = top;
    }

    public void initialize (int width){
        this.height = width;
        this.width = width;
    }

    public void  initialize (int left,int top, int width,int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
