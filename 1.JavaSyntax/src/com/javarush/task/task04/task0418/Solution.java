package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(reader.readLine());
        int w = Integer.parseInt(reader.readLine());

        int min;

        if (q <= w) min = q;
        else min = w;

        System.out.println(min);
    }
}