package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 33; i++) {
            numbers.add(0);
        }

        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toCharArray();
            ArrayList<Character> letters = new ArrayList<Character>();
            for (int j = 0; j < chars.length; j++) {
                letters.add(chars[j]);
            }

            for (int j = 0; j < letters.size(); j++) {

                for (int k = 0; k < alphabet.size(); k++) {
                    if (letters.get(j).toString().equals(alphabet.get(k).toString())) {
                        int temp = numbers.get(k);
                        temp++;
                        numbers.set(k,temp);
                    }

                }

            }



        }

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + numbers.get(i));
        }


    }
}


