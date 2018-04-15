package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {



        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());
            int d = Integer.parseInt(reader.readLine());
            int e = Integer.parseInt(reader.readLine());

            int minimum = min(a, b, c, d, e);

            System.out.println("Minimum = " + minimum);
        }


        public static int min(int a, int b, int c, int d, int e) {
            int m1;
            int m2;
            int m3;
            int min;
            if (a < b) m1 = a; else m1 = b;

            if (c < d) m2 = c; else m2 = d;

            if (m1 < m2) m3 = m1; else m3 = m2;

            if (e < m3) min = e; else min = m3;
            return min;
        }
    }
