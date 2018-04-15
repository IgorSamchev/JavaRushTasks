package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) return;

        String tag = args[0];
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";
        ArrayList<String> list = new ArrayList<>();
        String text = "";
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int openCount = 0;
        int closeCount = 0;
        ArrayList<Integer> openList = new ArrayList<>();
        ArrayList<Integer> closeList = new ArrayList<>();
        ArrayList<Integer> fullList = new ArrayList<>();
        int lastKey = 0;
        int lastValue = 0;

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader1.readLine();
        reader1.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            list.add(line);
        }
        reader.close();

        for (String s : list) {
            text = text + s;
        }

        text = text.replaceAll("\r\n", "");


        Pattern openPattern = Pattern.compile(openTag);
        Pattern closePattern = Pattern.compile(closeTag);


        Matcher openMatcher = openPattern.matcher(text.toString());
        Matcher closeMatcher = closePattern.matcher(text.toString());

        while (openMatcher.find()) {
            int start = openMatcher.start();
            int end = openMatcher.end();
            map.put(start, end);
        }

        while (closeMatcher.find()) {
            int start = closeMatcher.start();
            int end = closeMatcher.end();
            map.put(start, end);
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

            int key = pair.getKey();
            int value = pair.getValue();

            if (text.substring(key, value).equals(openTag)) {
                openList.add(key);
                openCount++;

            }

            if (text.substring(key, value).equals(closeTag)) {
                closeList.add(value);
                closeCount++;
            }

            if (openCount == 1 && closeCount == 1){
                fullList.add(openCount);
                openCount = 0;
                closeCount = 0;
            }

            if (openCount > 0 && closeCount > 0 && openCount == closeCount) {
                fullList.add((openCount + closeCount) / 2);
               if (openCount > 1 && closeCount > 1 && openCount == closeCount){

               }

                openCount = 0;
                closeCount = 0;
            }
        }

        for (Integer aFullList : fullList) {
            String s = text.substring(openList.get(0), closeList.get(aFullList - 1));
            System.out.println(s);


            openList.remove(0);
            closeList.remove(0);


        }


    }
}
