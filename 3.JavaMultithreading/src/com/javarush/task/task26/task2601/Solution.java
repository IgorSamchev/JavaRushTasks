package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};
        sort(array);
    }

    public static Integer[] sort(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        Arrays.sort(array);

        int mediane;
        if (array.length % 2 == 0) {
            mediane = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        } else {
            mediane = array[array.length / 2];
        }

        Arrays.sort(array, Comparator.comparingInt(x -> Math.abs(mediane - x)));
        return array;
    }
}
