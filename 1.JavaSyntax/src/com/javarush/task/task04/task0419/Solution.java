package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        int a4 = Integer.parseInt(reader.readLine());

        int minPair1;
        int minPair2;
        int max;

        if (a1 > a2) minPair1 = a1;
        else minPair1 = a2;
        if (a3 > a4) minPair2 = a3;
        else minPair2 = a4;
        if (minPair1 >= minPair2) max = minPair1;
        else max = minPair2;

        System.out.println(max);
    }
}
