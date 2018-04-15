package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(reader.readLine(), true);
        FileInputStream inputStream2 = new FileInputStream(reader.readLine());
        FileInputStream inputStream3 = new FileInputStream(reader.readLine());

        while (inputStream2.available() > 0){
            byte[] buffer = new byte[inputStream2.available()];
            inputStream2.read(buffer);
            outputStream.write(buffer);
        }

        while (inputStream3.available() > 0){
            byte[] buffer = new byte[inputStream3.available()];
            inputStream3.read(buffer);
            outputStream.write(buffer);
        }
        reader.close();
        outputStream.close();
        inputStream2.close();
        inputStream3.close();
    }
}
