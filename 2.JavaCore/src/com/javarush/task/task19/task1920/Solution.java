package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        TreeMap<String, Double> map = new TreeMap<>();
        Double maximum = Double.MIN_VALUE;

        while (reader.ready()) {
            String line = reader.readLine();

            String[] s = line.split(" ");

            if (line.length() > 0) {
                String name = s[0];
                Double value = Double.parseDouble(s[1]);


                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + value);
                } else {
                    map.put(name, value);
                }
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            Double value = pair.getValue();
            if (value > maximum) {
                maximum = value;
            }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            String key = pair.getKey();
            Double value = pair.getValue();
            if (value.equals(maximum)) {
                System.out.println(key);
            }
        }

        reader.close();


    }
}
