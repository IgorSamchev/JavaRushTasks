package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);

        String text = "";
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
            text = new String(buffer);
        }

        String[] s = text.split(" ");

            byte[]test = new byte[s.length];
        for (int i = 0; i < s.length; i++) {
            int number = (int)Math.round(Double.parseDouble(s[i]));
            String tester = String.valueOf(number + " ");
            outputStream.write(tester.getBytes());

        }

        inputStream.close();
        outputStream.close();
    }
}
