package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static {
        labels.put(1.29, "1");
        labels.put(1.239, "2");
        labels.put(1.292, "3");
        labels.put(1.2319, "4");
        labels.put(1.2999, "5");
    }
}
