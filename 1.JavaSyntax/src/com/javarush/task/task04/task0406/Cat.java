package com.javarush.task.task04.task0406;

/* 
Реализовать метод setName
*/

public class Cat {
    private static String fullName;

    public void setName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;

       this.fullName = fullName;

    }

    public static void main(String[] args) {

    }
}
