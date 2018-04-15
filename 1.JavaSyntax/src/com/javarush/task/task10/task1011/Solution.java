package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        String s1;
        for (int i = 0; i < 40; i++) {
            s1 = s;
            s1 = s1.substring(i, s.length());
            System.out.println(s1);
        }

    }

}

