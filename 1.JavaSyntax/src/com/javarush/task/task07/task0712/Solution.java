package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrayList = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(reader.readLine());
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String s = "";

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() > max) max = arrayList.get(i).length();
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() < min) min = arrayList.get(i).length();
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() == min || arrayList.get(i).length() == max) {
                s = arrayList.get(i);
                break;
            }
        }

        System.out.println(s);

    }
}
