package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrays = new String[10];
        int[] arrysi = new int[10];

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = reader.readLine();
        }

        for (int i = 0; i < arrays.length ; i++) {
            arrysi[i] = arrays[i].length();
            System.out.println(arrysi[i]);
        }


    }
}
