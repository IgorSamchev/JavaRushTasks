package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {


        int b = 0;
        while   (b < 10) {
            int a = 0;
            while (a < 10) {
                System.out.print("S");
                a++;
            }
            b++;
            System.out.println();
        }

    }
}
