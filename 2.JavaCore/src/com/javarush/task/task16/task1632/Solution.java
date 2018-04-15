package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new ForthThread());
        threads.add(new FifthThread());
    }

    public static void main(String[] args) {
        threads.get(0).start();
        threads.get(1).start();
        threads.get(1).interrupt();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
    }

    public static class FirstThread extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class SecondThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread extends Thread {

        @Override
        public void run() {

            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ForthThread extends Thread implements Message {

        private boolean die = false;

        @Override
        public void run() {
            while (die == false) {
            }
        }

        @Override
        public void showWarning() {
            die = true;
        }
    }

    public static class FifthThread extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String s = null;
            while (true) {
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s.equals("N") == true)
                    break;

                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}