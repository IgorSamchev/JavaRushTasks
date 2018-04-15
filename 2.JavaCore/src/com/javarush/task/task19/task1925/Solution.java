package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        ArrayList<String> list = new ArrayList<>();

        while (reader.ready()) {
            String line = reader.readLine();
            String[] buffer = line.split(" ");
            for (int i = 0; i < buffer.length; i++) {
                list.add(buffer[i]);
            }
        }

        String buffer = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > 6) {
                buffer += list.get(i) + ',';
            }
        }
        buffer = buffer.substring(0, buffer.length() - 1);


        writer.write(buffer);

        reader.close();
        writer.close();
    }
}
