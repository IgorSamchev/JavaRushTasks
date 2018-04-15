package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int number = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < number; i++) {

            list.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(list);

        maximum = list.get(list.size() - 1);


        //напишите тут ваш код

        System.out.println(maximum);
    }
}
