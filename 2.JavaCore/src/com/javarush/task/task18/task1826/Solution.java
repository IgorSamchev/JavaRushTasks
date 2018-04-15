package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) return;

        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        if (args[0].equals("-e")){

            while (inputStream.available() > 0){
                int data = inputStream.read();
                data++;
                outputStream.write(data);
            }
        }

        if (args[0].equals("-d")){
            while (inputStream.available() > 0){
                int data = inputStream.read();
                data--;
                outputStream.write(data);
            }
        }

        inputStream.close();
        outputStream.close();


    }

}
