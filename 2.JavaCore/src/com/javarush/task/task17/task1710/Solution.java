package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormatPrt = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        //1 -c
        if (args[0].startsWith("-c")){
            Date date = null;
            try {
                date = dateFormat.parse(args[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (args[2].startsWith("м")){
                Person person = Person.createMale(args[1], date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            } else {
                Person person = Person.createFemale(args[1], date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }

        /////// 2 -u
        if (args[0].startsWith("-u")){
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName(args[2]);
            if (args[3].startsWith("м")){
                allPeople.get(index).setSex(Sex.MALE);
            } else {
                allPeople.get(index).setSex(Sex.FEMALE);
            }

            Date date = null;
            try {
                date = dateFormat.parse(args[4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            allPeople.get(index).setBirthDay(date);
        }

        ////////////3 -d
        if (args[0].startsWith("-d")){
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName(null);
            allPeople.get(index).setBirthDay(null);
            allPeople.get(index).setSex(null);

        }

        ////////// 4 -i

        if (args[0].startsWith("-i")){
            int index = Integer.parseInt(args[1]);
            System.out.println(allPeople.get(index).getName() + " " + (allPeople.get(index).getSex() == Sex.MALE ? "м" : "ж" ) + " " +
            dateFormatPrt.format(allPeople.get(index).getBirthDay()));

        }
    }
}
