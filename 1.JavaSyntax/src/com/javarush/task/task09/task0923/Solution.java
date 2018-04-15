package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> glas = new ArrayList<Character>();
        ArrayList<Character> negl = new ArrayList<Character>();
        String s = reader.readLine();
        char[] z = s.toCharArray();
        for (int i = 0; i < z.length; i++) {
            if (isVowel(z[i])) glas.add(z[i]);
            if (!isVowel(z[i])) negl.add(z[i]);
        }

        String space = " ";
        char sp = space.charAt(0);


        for (int i = 0; i < negl.size(); i++) {
            if (negl.get(i).equals(sp)) negl.remove(i);
        }

        for (char g : glas) {
            System.out.print(g + " ");
        }
        System.out.println();

        for (char w : negl) {
            System.out.print(w + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}