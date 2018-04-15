package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        public Human(int age, int weight, int height) {
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        private String name;
        private int age;
        private String address;
        private boolean sex;
        private int weight;
        private int height;

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, String address, int weight, int height) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.weight = weight;
            this.height = height;
        }

        public Human() {

        }

        public Human(String name, int age, String address, boolean sex, int weight, int height) {

            this.name = name;
            this.age = age;
            this.address = address;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name, int age, String address, boolean sex, int weight) {

            this.name = name;
            this.age = age;
            this.address = address;
            this.sex = sex;
            this.weight = weight;
        }

        public Human(String name, int age, String address, boolean sex) {

            this.name = name;
            this.age = age;
            this.address = address;
            this.sex = sex;
        }

        public Human(String name, int age, String address) {

            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human(String name, int age) {

            this.name = name;
            this.age = age;
        }

        public Human(String name) {

            this.name = name;
        }
    }
}
