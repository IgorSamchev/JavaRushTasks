package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream out2 = new FileOutputStream(s2);
        FileOutputStream out3 = new FileOutputStream(s3);

        while(inputStream.available()>0){

            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            out3.write(buffer, (int)(buffer.length / 2) + (buffer.length % 2), (int)(buffer.length / 2));
            out2.write(buffer, 0, (int)(buffer.length / 2) + (buffer.length % 2));
        }

        reader.close();
        inputStream.close();
        out2.close();
        out3.close();

    }
}