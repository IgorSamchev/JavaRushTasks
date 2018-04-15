package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 480);
        map.put("2", 510);
        map.put("3", 210);
        map.put("4", 310);
        map.put("5", 110);
        map.put("6", 710);
        map.put("7", 410);
        map.put("8", 110);
        map.put("9", 110);
        map.put("10", 10);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String,Integer> pair : map.entrySet()){
            String s = pair.getKey();
            int q  = pair.getValue();
            if (q < 500) list.add(s);
        }
        for (int i = 0; i < list.size() ; i++) {
            map.remove(list.get(i));
        }
    }

    public static void main(String[] args) {

        removeItemFromMap(createMap());
    }
}