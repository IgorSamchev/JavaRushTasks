package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;

        while (true) {
            String s = reader.readLine();
            int x;
            if (s.equals("сумма")) break;
            else x = Integer.parseInt(s);
            summ = summ + x;



        }

        System.out.println(summ);


    }
}
