package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("1", "2");
        map.put("3", "1");
        map.put("3", "2");
        map.put("4", "1");
        map.put("5", "2");
        map.put("6", "2");
        map.put("7", "2");
        map.put("8", "1");
        map.put("1", "1");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
