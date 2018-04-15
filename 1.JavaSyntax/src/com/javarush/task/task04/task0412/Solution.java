package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());

        if (x > 0) System.out.println(x*2);
        if (x < 0) System.out.println(x+1);
        if (x == 0) System.out.println(0);
    }

}