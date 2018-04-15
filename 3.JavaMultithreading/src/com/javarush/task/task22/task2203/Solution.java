package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty())
            throw new TooShortStringException();

        String[] split = string.split("\t");
        if (split.length < 3) {
            throw new TooShortStringException();
        }
        return split[1];
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));

    }

    public static class TooShortStringException extends Exception {
    }
}
