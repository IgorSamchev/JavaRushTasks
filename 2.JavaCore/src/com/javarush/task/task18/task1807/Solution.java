package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        int count = 0;

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if (data == 44){
                count++;
            }
        }
        inputStream.close();

        System.out.println(count);

    }
}
