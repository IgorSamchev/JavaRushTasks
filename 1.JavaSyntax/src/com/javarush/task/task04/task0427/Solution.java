package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        if (a > 0 && a <= 999) {

            if (a % 2 == 0) System.out.print("четное");
            else System.out.print("нечетное");

            if (a > 0 && a < 10) System.out.println(" однозначное число");
            else if (a > 9 && a < 100) System.out.println(" двузначное число");
            else if (a > 99 && a <= 999) System.out.println(" трехзначное число");
        }

    }
}
