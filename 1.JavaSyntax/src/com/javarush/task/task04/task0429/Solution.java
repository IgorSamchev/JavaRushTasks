package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countM = 0;
        int countP = 0;

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a > 0) countP++;
        else if (a < 0) countM++;

        if (b > 0) countP++;
        else if (b < 0) countM++;

        if (c > 0) countP++;
        else if (c < 0) countM++;

        System.out.println("количество отрицательных чисел: " + countM);
        System.out.println("количество положительных чисел: " + countP);
    }
}
