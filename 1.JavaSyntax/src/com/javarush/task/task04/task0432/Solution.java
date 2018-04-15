package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        int a = Integer.parseInt(reader.readLine());

        while (a > 0){
            System.out.println(text);
            a--;
        }

    }
}
