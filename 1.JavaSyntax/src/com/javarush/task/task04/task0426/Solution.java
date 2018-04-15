package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());

        if (a > 0) System.out.print("положительное ");
        else if (a < 0) System.out.print("отрицательное ");
        else System.out.print("ноль");

        if (a % 2 == 0 && a != 0) System.out.print("четное число");
        else if (a % 2 != 0 && a != 0) System.out.print("нечетное число");
    }
}
