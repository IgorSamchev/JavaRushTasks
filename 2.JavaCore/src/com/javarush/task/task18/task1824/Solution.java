package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            while (true) {
                line = reader.readLine();
                File file = new File(line);
                FileInputStream inputStream = new FileInputStream(file);
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(line);
        }
    }
}
