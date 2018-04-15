package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(args[0]);
        int count = 0;

        while (is.available() > 0){
            int data = is.read();
            if (data >= (int) 'A' && data <= (int) 'Z' ||
                    data >= (int) 'a' && data <= (int) 'z'){
                count++;
            }
        }
        is.close();
        System.out.println(count);
    }
}
