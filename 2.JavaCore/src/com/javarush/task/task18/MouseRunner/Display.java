package com.javarush.task.task18.MouseRunner;

public class Display extends Thread {
    private int x;
    private int y;

    public Display(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
