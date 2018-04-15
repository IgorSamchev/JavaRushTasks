package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String,Double> map = new TreeMap<>();
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            String line = reader.readLine();

            if (line.length() > 0) {

                String[] separator = line.split(" ");
                String name = separator[0];
                Double money = Double.parseDouble(separator[1]);

                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + money);
                } else {
                    map.put(name, money);
                }
            }
        }

        for (Map.Entry<String,Double> pair : map.entrySet()){
            String key = pair.getKey();
            Double value = pair.getValue();
            System.out.println( key + " " + value);
        }
        reader.close();
    }
}
