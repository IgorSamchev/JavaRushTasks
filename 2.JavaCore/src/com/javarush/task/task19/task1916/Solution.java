package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileNAme2 = br.readLine();
        br.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileNAme2));
        ArrayList<String> original = new ArrayList<>();
        ArrayList<String> modified = new ArrayList<>();

        while (reader1.ready()) {
            original.add(reader1.readLine());
        }
        while (reader2.ready()) {
            modified.add(reader2.readLine());
        }
        reader1.close();
        reader2.close();

        while (original.size() != 0 & modified.size() != 0) {
            if (original.get(0).equals(modified.get(0))) {
                lines.add(new LineItem(Type.SAME, original.get(0)));
                original.remove(0);
                modified.remove(0);
            }
            else if (original.get(0).equals(modified.get(1))) {
                lines.add(new LineItem(Type.ADDED, modified.get(0)));
                modified.remove(0);
            }
            else if (original.get(1).equals(modified.get(0))) {
                lines.add(new LineItem(Type.REMOVED, original.get(0)));
                original.remove(0);
            }
        }

        if (original.size() != 0) {
            lines.add(new LineItem(Type.REMOVED, original.get(0)));
            original.remove(0);
        }
        if (modified.size() != 0) {
            lines.add(new LineItem(Type.ADDED, modified.get(0)));
            modified.remove(0);
        }

        for (LineItem x : lines){
            System.out.println(x);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
