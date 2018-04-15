package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method1() {
        method2();
                StackTraceElement[] element = Thread.currentThread().getStackTrace();
        System.out.println(element);
        return element;
    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element;
    }

    public static StackTraceElement[] method3() {
        method4();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        System.out.println(element);
        return element;
    }

    public static StackTraceElement[] method4() {
        method5();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        System.out.println(element);
        return element;
    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        System.out.println(element);
        return element;
    }
}
