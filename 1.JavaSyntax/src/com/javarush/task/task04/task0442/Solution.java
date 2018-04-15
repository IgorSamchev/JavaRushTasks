package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        while (true){
            int x = Integer.parseInt(reader.readLine());
            count = count + x;

            if (x == -1)
                break;

        }

        System.out.println(count);
    }
}
