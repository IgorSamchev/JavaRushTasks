package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String filename = reader.nextLine();

        FileInputStream f = new FileInputStream(filename);

        HashMap<Integer, Integer> mapOfByte = new HashMap<Integer, Integer>();

        int data = 0;
        Integer count = 0;
        while (f.available() > 0) {
            data = f.read();

            count = mapOfByte.get(data);

            if (count != null)
                count++;
            else
                count = 0;

            mapOfByte.put(data, count);
        }

        f.close();

        boolean first = true;
        int max = 0;
        for (int amountByte : mapOfByte.values()) {
            if (first) {
                max = amountByte;
                first = false;
            }
            if (max < amountByte)
                max = amountByte;
        }

        //Выводим
        for (Map.Entry pair : mapOfByte.entrySet()) {
            if (max == (int) pair.getValue())
                System.out.print(" " + pair.getKey());
        }

    }
}