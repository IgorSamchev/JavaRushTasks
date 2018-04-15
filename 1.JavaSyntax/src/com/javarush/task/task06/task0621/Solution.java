package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = reader.readLine();
        Cat dedushka = new Cat(dedName, null, null);

        String babkaName = reader.readLine();
        Cat babka = new Cat(babkaName, null, null);

        String fatherName = reader.readLine();
        Cat papa = new Cat(fatherName, dedushka, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, babka);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, papa, catMother);

        String sin = reader.readLine();
        Cat sinok = new Cat(sin, papa, catMother);


        System.out.println(dedushka);
        System.out.println(babka);
        System.out.println(papa);
        System.out.println(catMother);
        System.out.println(catDaughter);
        System.out.println(sinok);

    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;


        public Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String s = "";
            if (mother == null && father != null)
                s = ("Cat name is " + name + ", no mother, " + "father is " + father.name);
            if (father == null && mother != null)
                s = ("Cat name is " + name + ", mother is " + mother.name + ", no father");
            if (mother == null && father == null)
                s = ("Cat name is " + name + ", no mother" + ", no father");
            if (mother != null && father != null)
                s = ("Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name);
            return s;
        }
    }

}
