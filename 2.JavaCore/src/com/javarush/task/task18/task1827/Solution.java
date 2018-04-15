package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//public class Solution {
//    public static void main(String[] args) throws Exception {
//        if (args.length < 4 || !args[0].equals("-c")) return;
//        String price = args[args.length-2];
//        String quantty = args[args.length-1];
//
//
//        //Если у нас аргументов больше 4 из-за пробелов в строке productName
//        String productName;
//        if (args.length > 4) {
//            StringBuffer buf = new StringBuffer();
//            for (int i = 1; i < args.length - 2; i++)
//                buf.append(args[i]).append(" ");
//            productName = buf.substring(0, buf.length() - 1);
//        } else
//            productName = args[1];
//
//        //Read file name from console
//        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = consoleReader.readLine();
//        consoleReader.close();
//
//        //Let's find ID
//        ArrayList<Integer> IDsList = new ArrayList<>();
//        BufferedReader inputstream = new BufferedReader(new FileReader(fileName1));
//        while (inputstream.ready()){
//            String line = inputstream.readLine();
//            if (line.length() > 0) {
//                String s = line.substring(0, 8);
//                s = s.replace(" ", "");
//                try {
//                    int iDNumber = Integer.parseInt(s);
//                    ////////////////////////////////
//                    IDsList.add(iDNumber);
//                }catch (Exception e){}
//            }
//        }
//        Collections.sort(IDsList);
//
//        int maxID = (IDsList.get(IDsList.size()-1))+1;
//
//
//        while ( productName.length() < 30){
//            productName = productName + " ";
//        }
//
//        while (price.length() < 8){
//            price = price + " ";
//        }
//
//        while (quantty.length() < 4){
//            quantty = quantty + " ";
//        }
//
//        String result = maxID+productName+price+quantty;
//
//
//        BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(fileName1, true));
//
//        fileOutputStream.newLine();
//        fileOutputStream.write(result);
//
//
//        fileOutputStream.close();
//        inputstream.close();
//
//    }
//}