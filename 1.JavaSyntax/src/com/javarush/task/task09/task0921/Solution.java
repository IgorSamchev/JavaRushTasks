package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                int x = Integer.parseInt(reader.readLine());
                list.add(x);
            }

        } catch (IOException e){
            for (int w : list) System.out.println(w);
        } catch (NumberFormatException e) {
            for (int w : list) System.out.println(w);
        }

    }
}
