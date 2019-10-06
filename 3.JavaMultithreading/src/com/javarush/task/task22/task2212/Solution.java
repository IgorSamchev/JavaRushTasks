package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Проверка номера телефона
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        int length = telNumber.replaceAll("\\D", "").length();
        if (telNumber.contains("[a-aA-Z]")) {
            return false;
        }
        if (length == 12) {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        } else if (length == 10) {
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, Boolean> phones = new LinkedHashMap<>();
        ArrayList<String> list = new ArrayList<>();
        phones.put("+380501234567", true);
        phones.put("+38(050)1234567-", false);
        phones.put("+38050(123)(456)7", false);
        phones.put("++380501234567-", false);
        phones.put("(380)501234567", false);
        phones.put("+38050123--4567", false);
        phones.put("050123--4567", false);
        phones.put("0-50123-4567", true);
        phones.put("+38)050(1234567", false);
        phones.put("050���4567", false);
        phones.put("050123456=false", false);
        phones.put("+38(050)1-23-45-6-7", false);
        phones.put("050ххх4567", false);
        phones.put("050123456", false);
        phones.put("(0)501234567", false);
        phones.put("+38-(050)1234567", false);
        phones.put("+38((050)1234567", false);
        phones.put("+5(0--5)1234567", false);
        phones.put("1-23456789-0", true);
        phones.put("+38051202(345)-7", true);
        phones.put("+38051202(345)7", true);
        phones.put("(345)0512027", true);
        phones.put("+-313450531202", true);
        phones.put("+313450--531202", false);
        phones.put("38xx501A34567", false);
        phones.put("3805012345", true);
        phones.put("+38(0501234567", false);
        phones.put("+38(050)1234567", true);
        phones.put("+38(05)1234567", false);
        phones.put("(3)80501234567", false);
        phones.put("380-50123-45", true);
        phones.put("(380)501-234567", false);
        phones.put("(38-0)501234567", false);
        phones.put("380-(501)234567", false);
        phones.put("380(50-1)234567", false);
        phones.put("380(501)(23)4567", false);
        phones.put("+38050123(456)7", true);
        phones.put("+38050123(456)76", false);
        phones.put("+380501234(567)", false);
        phones.put("3-805-0123-45", false);
        phones.put("-3805-012345", false);
        phones.put("3805-012345-", false);
        phones.put("+38(05)01234567", false);
        phones.put("+38(0501)234567", false);
        phones.put("+38050123-45-67", true);
        phones.put("050123-4567", true);
        phones.put("7-4-4123689-5", false);
        phones.put("+313450--531202Э", false);
        phones.put("++380501234567", false);
        phones.put("(111)111111111", false);
        phones.put("AB", false);
        phones.put("1AB1", false);
        phones.put("aB", false);
        phones.put("12345678910", false);
        phones.put("+38", false);
        phones.put("222222-2222", true);
        phones.put("(050)34(125)6-7", false);
        for (Map.Entry<String, Boolean> entry : phones.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " | " + checkTelNumber(entry.getKey()));
        }
    }
}