package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(reader.readLine());
        int t2 = Integer.parseInt(reader.readLine());
        int t3 = Integer.parseInt(reader.readLine());

        if (t1 + t2 > t3 && t1 + t3 > t2 && t2 + t1 > t3 && t2 + t3 > t1 && t3 + t1 > t2 && t3 + t2 > t1)
            System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");


    }
}