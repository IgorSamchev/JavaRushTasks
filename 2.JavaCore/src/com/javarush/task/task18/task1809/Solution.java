package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);

        byte[] buffer = new byte[inputStream.available()];
        byte[] reverse = new byte[inputStream.available()];
        int count = 0;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            buffer[count] = (byte) data;
            count++;
        }

        for (int i = 0; i < buffer.length; i++) {
            reverse[i] = buffer[buffer.length-i-1];
        }

        outputStream.write(reverse);

        inputStream.close();
        outputStream.close();
    }

}
