package com.javarush.task.task09.task0930;

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
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<Integer> integers = new ArrayList<Integer>();
        ArrayList<Integer> reverse = new ArrayList<Integer>();
        String[] result = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                integers.add(Integer.parseInt(array[i]));
            } else strings.add(array[i]);
        }

        Collections.sort(strings);
        Collections.sort(integers);
        Collections.reverse(integers);

        String a = "1";
        String b = "2";
        isGreaterThan(a,b);




        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                result[i] = integers.get(0).toString();
                integers.remove(0);
            } else {
                result[i] = strings.get(0);
                strings.remove(0);
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }


    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
