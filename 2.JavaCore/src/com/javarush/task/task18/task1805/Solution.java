package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (inputStream.available() > 0){
            int data = inputStream.read();
            map.put(data,null);
        }

        inputStream.close();

        for (Map.Entry<Integer,Integer> pair : map.entrySet()){
            int key = pair.getKey();
            list.add(key);
        }

        Collections.sort(list);

        for (int x : list) System.out.print(x + " ");
    }
}
