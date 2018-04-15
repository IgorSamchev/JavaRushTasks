package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        //name=Ivanov, country=Ukraine, city=Kiev, age=null
        //name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
        map1.put("name", null);
        map1.put("country", null);
        map1.put("city", null);
        map1.put("age", null);

        LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
        map2.put("name", "Petrov");
        map2.put("country", "Estonia");
        map2.put("city", "Tallinn");
        map2.put("age", "26");



        System.out.println(getQuery(map1));
        System.out.println(getQuery(map2));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, String> pair : params.entrySet()) {

            String key = pair.getKey();
            String value = pair.getValue();
            if (value != null) {
                sb.append(key).append(" = ").append("'").append(value).append("'").append(" and ");
                count++;

            }
        }

        if (count > 0){
            sb.replace(sb.length()-5, sb.length(), "");
            return String.valueOf(sb);
        } else {
            String s = "";
            return s;
        }
    }
}
