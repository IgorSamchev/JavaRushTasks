package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.put("4", "2");
        map.put("5", "3");
        map.put("6", "4");
        map.put("7", "5");
        map.put("8", "4");
        map.put("9", "4");
        map.put("10", "4");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            if (value.equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            String key = pair.getKey();
            if (key.equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        getCountTheSameFirstName(map, "2");
        getCountTheSameLastName(map,"1");
    }
}
