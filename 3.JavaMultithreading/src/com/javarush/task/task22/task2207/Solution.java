package com.javarush.task.task22.task2207;


import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
        ArrayList<String> dataline = new ArrayList<String>();
        //Записываем все слова из файла в ArrayList.
        while(in.ready()){
            dataline.addAll(Arrays.asList((in.readLine().split(" "))));
        }
        in.close();
        /* ArrayList<String> dataline = new ArrayList<>();
        dataline.add("рот"); dataline.add("тор"); dataline.add("рот"); dataline.add("торт");dataline.add("о");
        dataline.add("о"); dataline.add("тот");dataline.add("тот"); dataline.add("тот"); dataline.add("еще");
        dataline.add("жизнь"); dataline.add("жизнь");*/

        Map<String, String> pairs = new HashMap<>();
        for (int i = 0; i < dataline.size(); i++)
        {
            String usual = dataline.get(i);
            StringBuilder usualreversebuilder = new StringBuilder(usual);
            String usualreverse = usualreversebuilder.reverse().toString();

            {
                for (int j = i + 1; j < dataline.size(); j++)
                {
                    // 1 если такой ключ уже есть
                    if (pairs.containsKey(usual)) {continue;}
                    // 2 если такой ключ, только перевернутый, уже есть, т.е повтор
                    if (pairs.containsKey(usualreverse)) {continue;}


                    StringBuilder sb = new StringBuilder(dataline.get(j));
                    String reverse = sb.reverse().toString();

                    //2 условие если строка реверсивна следующей
                    if (usual.equals(reverse))
                    {
                        pairs.put(usual, sb.reverse().toString());
                    }
                }
            }
        }

        for(Map.Entry<String,String> entry: pairs.entrySet()) {
            Pair pair = new Pair();
            pair.first = entry.getKey(); pair.second=entry.getValue();
            result.add(pair);
        }
        for (Pair p: result) {
            System.out.println(p.first + " "  + p.second);
        }
    }

    public static class Pair {
        String first;

        public Pair() {
        }

        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
