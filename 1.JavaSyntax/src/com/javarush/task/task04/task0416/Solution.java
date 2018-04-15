package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double t = Double.parseDouble(reader.readLine());

        while (t >= 5) {
            t = t - 5;
        }

        if (t >= 0 && t < 3) System.out.println("зелёный");
        if (t >= 3 && t < 4) System.out.println("жёлтый");
        if (t >= 4 && t < 5) System.out.println("красный");


    }
}