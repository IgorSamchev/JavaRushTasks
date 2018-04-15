package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int value = pair.getValue();
            if (value < min) min = value;
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int value = pair.getValue();
            int key = pair.getKey();
            if (value == min) {
                list.add(key);
            }
        }

        inputStream.close();

        for (int q : list) System.out.print(q + " ");


    }
}
