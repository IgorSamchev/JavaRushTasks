package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());

        if (x == 1) System.out.println("понедельник");
        else if (x == 2) System.out.println("вторник");
        else if (x == 3) System.out.println("среда");
        else if (x == 4) System.out.println("четверг");
        else if (x == 5) System.out.println("пятница");
        else if (x == 6) System.out.println("суббота");
        else if (x == 7) System.out.println("воскресенье");
        else System.out.println("такого дня недели не существует");

    }
}