package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test.txt"));
        Solution savedObjects = new Solution(3);
        outputStream.writeObject(savedObjects);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test.txt"));
        Solution loadedObjects = (Solution)inputStream.readObject();

        boolean test;

        if (savedObjects.toString().equals(loadedObjects.toString()))
            test =  true;
        else test = false;

        System.out.println("test = " + test);
        System.out.println(savedObjects);
        System.out.println(loadedObjects);
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
