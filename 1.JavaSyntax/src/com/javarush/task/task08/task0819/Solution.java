package com.javarush.task.task08.task0819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator iterator = cats.iterator();
        if (iterator.hasNext()) {
            cats.remove(iterator.next());
        }
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> set = new HashSet<Cat>();
        set.add(new Cat());
        set.add(new Cat());
        set.add(new Cat());
        return set;
    }

    public static void printCats(Set<Cat> cats) {
        for(Cat x : cats) System.out.println(x);
    }

    public static class Cat{

    }
}
