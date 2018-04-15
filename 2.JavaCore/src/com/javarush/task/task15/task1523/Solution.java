package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String name;
    int age;

    public Solution() {
    }

    public static void main(String[] args) {

    }

    protected Solution(String name){
        this.name = name;
    }

    private Solution(int age){
        this.age = age;
    }

    Solution(String name, int age){

    }
}

