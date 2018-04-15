package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        Scanner sc = new Scanner(new FileInputStream(fileName));
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (sc.hasNextInt()) {
            int temp = sc.nextInt();
            if (temp % 2 == 0){list.add(temp);}


        }

        Collections.sort(list);
        for (int x : list) System.out.println(x);
        sc.close();
        br.close();
    }
}
