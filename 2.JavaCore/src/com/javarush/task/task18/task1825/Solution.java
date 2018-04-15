package com.javarush.task.task18.task1825;

/*
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;


        while (true) {
            String line = reader.readLine();
            if (line.equals("end")) {
                break;
            }
            list.add(line);
        }

        String fileName = list.get(0).substring(0, list.get(0).lastIndexOf(".part"));

        reader.close();
        Collections.sort(list);

        FileOutputStream outputStream = new FileOutputStream(fileName, true);

        for (String aList : list) {
            inputStream = new FileInputStream(aList);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            inputStream.close();

        }

        outputStream.close();
    }
}