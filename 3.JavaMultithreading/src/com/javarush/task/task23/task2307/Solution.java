package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object objs;

    public static void main(String[] args) {
        objs = new Solution.TEST();
        System.out.println(objs);
    }
}
