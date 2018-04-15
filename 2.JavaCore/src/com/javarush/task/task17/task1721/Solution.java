package com.javarush.task.task17.task1721;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();


        Scanner sc1 = new Scanner(file1);
        while (sc1.hasNextLine()) {
            allLines.add(sc1.nextLine());
        }

        Scanner sc2 = new Scanner(file2);
        while (sc2.hasNextLine()) {
            forRemoveLines.add(sc2.nextLine());
        }
        sc1.close();
        sc2.close();

        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);

        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
