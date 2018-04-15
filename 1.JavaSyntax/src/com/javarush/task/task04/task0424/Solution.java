package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();


        if (a.equals(b) && !a.equals(c)) System.out.println("3");
        else if (a.equals(c) && !a.equals(b)) System.out.println("2");
        else if (b.equals(a) && !b.equals(c)) System.out.println("3");
        else if (b.equals(c) && !b.equals(a)) System.out.println("1");
        else if (c.equals(a) && !c.equals(b)) System.out.println("2");
        else if (c.equals(b) && !c.equals(a)) System.out.println("1");
    }
}
