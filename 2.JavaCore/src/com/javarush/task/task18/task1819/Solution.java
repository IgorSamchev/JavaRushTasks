package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1, true);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream1 = new FileInputStream(fileName1);

        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream2.available() > 0){
            int data =  inputStream2.read();
            list.add(data);
        }

        while (inputStream1.available() > 0){
            int data =  inputStream1.read();
            list.add(data);
        }


        for (int x : list) {
            outputStream.write(x);
        }



        outputStream.close();
        inputStream1.close();
        inputStream2.close();
    }
}
