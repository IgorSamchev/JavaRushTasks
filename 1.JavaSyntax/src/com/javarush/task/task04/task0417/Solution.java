package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int q1 = Integer.parseInt(reader.readLine());
        int q2 = Integer.parseInt(reader.readLine());
        int q3 = Integer.parseInt(reader.readLine());

        if (q1 == q2 && q2 == q3) System.out.println(q1 + " " + q2 + " " + q3);
        else if (q1 == q2) System.out.println(q1 + " " + q2);
        else if (q1 == q3) System.out.println(q1 + " " + q3);
        else if (q2 == q1) System.out.println(q2 + " " + q1);
        else if (q2 == q3) System.out.println(q2 + " " + q3);
        else if (q3 == q1) System.out.println(q3 + " " + q1);
        else if (q3 == q2) System.out.println(q3 + " " + q2);
    }
}