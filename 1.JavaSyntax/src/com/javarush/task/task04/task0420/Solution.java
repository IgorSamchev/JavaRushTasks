package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int a1 = Integer.parseInt(reader.readLine());
            arrayList.add(a1);
        }

        Collections.sort(arrayList);
        System.out.println(arrayList.get(2) + " " + arrayList.get(1) + " " + arrayList.get(0));
    }
}
