package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        int a= Integer.parseInt(reader.readLine());
        int b= Integer.parseInt(reader.readLine());
        int c= Integer.parseInt(reader.readLine());

        if (a > 0) count++;
        if (b > 0) count++;
        if (c > 0) count++;

        System.out.println(count);



    }
}
