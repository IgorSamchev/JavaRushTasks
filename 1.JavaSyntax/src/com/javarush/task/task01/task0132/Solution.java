package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(5455596));
    }

    public static int sumDigitsInNumber(int number) {
        String x = String.valueOf(number);
        char[] array = x.toCharArray();
        int summ = 0;

        for (int i = 0; i < array.length; i++) {
            int z = Character.getNumericValue(array[i]);
            summ = summ + z;

        }

        return summ;
    }
}