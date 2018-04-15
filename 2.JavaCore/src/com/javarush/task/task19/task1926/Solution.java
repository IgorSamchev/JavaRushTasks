package com.javarush.task.task19.task1926;

/* 
???????????
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()){
            String line = reader.readLine();
            StringBuilder build = new StringBuilder(line).reverse();
            System.out.println(build);

        }
        br.close();
        reader.close();
    }
}
