package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bigArray = new int[20];
        int[] small1 = new int[10];
        int[] small2 = new int[10];

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < bigArray.length/2; i++) {
            small1[i] = bigArray[i];
        }

        for (int i = bigArray.length/2; i < bigArray.length ; i++) {
            small2[i-bigArray.length/2] = bigArray[i];
            System.out.println(small2[i-bigArray.length/2]);
        }
    }
}
