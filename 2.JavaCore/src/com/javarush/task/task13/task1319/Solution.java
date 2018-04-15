package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = breader.readLine();
        ArrayList<String> list = new ArrayList<String>();
        String line;

        while (true){
            line = breader.readLine();
            list.add(line);
            if (line.equals("exit")) break;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i));
            bw.newLine();
        }

        breader.close();
        bw.close();


    }
}
