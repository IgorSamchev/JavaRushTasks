package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream backup = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newStream);
        testString.printSomething();
        String line = byteArrayOutputStream.toString();
        System.setOut(backup);

        String[] separator = line.split(" ");
        String znak = separator[1];




        switch (znak){
            case "+":
                int c = Integer.valueOf(separator[0]) + Integer.valueOf(separator[2]);
                System.out.println(Integer.valueOf(separator[0]) + " + " + Integer.valueOf(separator[2]) + " = " + c);
                break;

            case "-":
                int d = Integer.valueOf(separator[0]) - Integer.valueOf(separator[2]);
                System.out.println(Integer.valueOf(separator[0]) + " - " + Integer.valueOf(separator[2]) + " = " + d);
                break;

            case "*":
                int e = Integer.valueOf(separator[0])*Integer.valueOf(separator[2]);
                System.out.println(Integer.valueOf(separator[0]) + " * " + Integer.valueOf(separator[2]) + " = " + e);
                break;
            }
        }




    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

