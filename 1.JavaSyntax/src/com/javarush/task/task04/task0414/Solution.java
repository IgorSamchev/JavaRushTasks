package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int z;

        if (x % 4 != 0) z = 365;
            else if (x % 100 == 0 && x % 400 != 0) z = 365;
            else z = 366;

        System.out.println("количество дней в году: " + z);
    }
}