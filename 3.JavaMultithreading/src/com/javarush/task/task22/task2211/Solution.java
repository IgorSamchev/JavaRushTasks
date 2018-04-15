package com.javarush.task.task22.task2211;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream reader = new FileInputStream(args[0]);
        FileOutputStream  writer = new FileOutputStream(args[1]);
        while (reader.available() > 0) {
            byte[] buff = new byte[1000];
            int count = reader.read(buff);
            String line = new String(buff, 0, count, "WINDOWS-1251");
            buff = line.getBytes("UTF-8");
            writer.write(buff, 0, buff.length);

        }
        reader.close();
        writer.close();
    }
}

