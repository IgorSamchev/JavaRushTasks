package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
      Human child1 = new Human("Child1", false, 16, null);
      Human child2 = new Human("Child2", true,17, null);
      Human child3 = new Human("Child3", false, 11, null);

      ArrayList<Human> child = new ArrayList<Human>();
      child.add(child1);
      child.add(child2);
      child.add(child3);

      Human father = new Human("Father", true,42, child);
      Human mother = new Human("Mother", false, 43, child);

      ArrayList<Human> parents1 = new ArrayList<Human>();
      parents1.add(father);

      ArrayList<Human> parents2 = new ArrayList<Human>();
      parents2.add(mother);

      Human grandfather1 = new Human("Grandfather1", true, 61, parents1);
      Human grandfather2 = new Human("Grandfather2", true, 62, parents2);
      Human grandmother1 = new Human("Grandmother1", false, 61, parents1);
      Human grandmother2 = new Human("Grandmother2", false, 62, parents2);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);


    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.children==null)
                return text;


            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
