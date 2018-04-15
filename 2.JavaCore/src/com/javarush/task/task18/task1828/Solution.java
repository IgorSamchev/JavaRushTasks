package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals("-d")) {

            int currentline = 0;

            ArrayList<String> lines = new ArrayList<>();
            BufferedReader consoleReader2 = new BufferedReader(new InputStreamReader(System.in));
            String fileName2 = consoleReader2.readLine();
            consoleReader2.close();

            //Let's find ID
            BufferedReader inputstream2 = new BufferedReader(new FileReader(fileName2));
            while (inputstream2.ready()) {
                String line2 = inputstream2.readLine();
                if (line2.length() > 0) {
                    lines.add(line2);
                    String s = line2.substring(0, 8);
                    s = s.replace(" ", "");
                    try {
                        int iDNumber = Integer.parseInt(s);
                        if (iDNumber == Integer.parseInt(args[1])) {
                            lines.remove(currentline);
                        }

                    } catch (Exception ignored) {
                    }
                    currentline++;
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2, false));
            for (int i = 0; i < lines.size(); i++) {
                bufferedWriter.write(lines.get(i));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            inputstream2.close();

        }

        if (args.length < 5 || !args[0].equals("-u")) return;
        String price = args[args.length - 2];
        String quantty = args[args.length - 1];


        //Если у нас аргументов больше 4 из-за пробелов в строке productName
        String productName;
        if (args.length > 5) {
            StringBuilder buf = new StringBuilder();
            for (int i = 2; i < args.length - 2; i++)
                buf.append(args[i]).append(" ");
            productName = buf.substring(0, buf.length() - 1);
        } else
            productName = args[2];

        //Read file name from console
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = consoleReader.readLine();
        consoleReader.close();

        while (productName.length() < 30) {
            productName = productName + " ";
        }

        while (price.length() < 8) {
            price = price + " ";
        }

        while (quantty.length() < 4) {
            quantty = quantty + " ";
        }

        //Let's find ID

        ArrayList<String> lines = new ArrayList<>();
        BufferedReader inputstream = new BufferedReader(new FileReader(fileName1));
        int iID = 0;

        while (inputstream.ready()) {
            String line = inputstream.readLine();
            lines.add(line);
            if (line.length() > 0) {
                String s = line.substring(0, 8);
                s = s.replace(" ", "");
                try {
                    int iDNumber = Integer.parseInt(s);
                    if (iDNumber == Integer.parseInt(args[1])) {
                        String id2 = String.valueOf(iDNumber);
                        while (id2.length() < 8){
                            id2 = id2 + " ";
                        }
                        String result = id2 + productName + price + quantty;
                        lines.add(result);
                        lines.remove(lines.size()-2);
                    }
                } catch (Exception ignored) {
                }
                iID++;
            }
        }


        BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(fileName1, false));

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).length() > 0) {
                fileOutputStream.write(lines.get(i));
                fileOutputStream.newLine();
            }
        }


        fileOutputStream.close();
        inputstream.close();


    }

}
