package com.javarush.task.task20.task2002;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Roman");
            user.setLastName("Last");
            user.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("21.03.1991"));
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            ObjectOutputStream outToFile = new ObjectOutputStream(outputStream);
            outToFile.write(users.size());
            for (User usr : users) {
                String firstName = usr.getFirstName() != null ? usr.getFirstName() : "null";
                String lastName = usr.getLastName() != null ? usr.getLastName() : "null";
                Long birthDate = usr.getBirthDate().getTime();
                String country = usr.getCountry() != null ? usr.getCountry().toString() : "null";
                Boolean sex = usr.isMale();

                outToFile.writeObject(firstName);
                outToFile.writeObject(lastName);
                outToFile.writeLong(birthDate);
                outToFile.writeObject(country);
                outToFile.writeBoolean(sex);
                outToFile.flush();
                outToFile.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            ObjectInputStream in = new ObjectInputStream(inputStream);

            int usersCount = in.readInt();
            for (int i = 0; i < usersCount; i++) {
                String firstName = (String) in.readObject();
                String lastName = (String) in.readObject();
                long birthDate = in.readLong();
                String country = (String) in.readObject();
                Boolean sex = in.readBoolean();

                User usr = new User();
                usr.setFirstName(firstName);
                usr.setLastName(lastName);
                usr.setBirthDate(new Date(birthDate));
                usr.setCountry(User.Country.valueOf(country));
                usr.setMale(sex);

                users.add(usr);

            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
