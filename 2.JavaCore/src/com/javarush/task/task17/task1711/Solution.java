package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormatPrt = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    Date date = null;
                    try {
                        date = dateFormat.parse(args[i + 2]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Person person;
                    if (args[i + 1].startsWith("м")) {
                        person = Person.createMale(args[i], date);
                    } else {
                        person = Person.createFemale(args[i], date);
                    }
                    synchronized (allPeople) {
                        allPeople.add(person);
                    }
                    System.out.println(allPeople.indexOf(person));
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(args[i + 1]);
                        Date date = null;
                        try {
                            date = dateFormat.parse(args[i + 3]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (args[i + 2].startsWith("м")) {
                            allPeople.get(index).setSex(Sex.MALE);
                        } else {
                            allPeople.get(index).setSex(Sex.FEMALE);
                        }
                        allPeople.get(index).setBirthDay(date);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setSex(null);
                        allPeople.get(index).setBirthDay(null);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
                        String date = dateFormatPrt.format(person.getBirthDay());
                        System.out.println(person.getName() + " " + sex + " " + date);
                    }
                }
                break;
        }
    }
}
