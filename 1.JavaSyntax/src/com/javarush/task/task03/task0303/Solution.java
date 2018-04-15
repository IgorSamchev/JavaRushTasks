package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(100,1.15));
        System.out.println(convertEurToUsd(150,1.15));
    }

    public static double convertEurToUsd(int eur, double course) {
        double changed = eur*course;
        return changed;
    }
}
