package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        LatteMaker latte = new LatteMaker();
        latte.makeDrink();
        System.out.println();
        TeaMaker tea = new TeaMaker();
        tea.makeDrink();
    }
}
