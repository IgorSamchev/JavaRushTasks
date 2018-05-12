package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thr : threads){
            switch (thr.getState()){
                case NEW:
                    thr.start();
                    break;
                case BLOCKED:
                    thr.interrupt();
                    break;
                case RUNNABLE:
                    thr.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thr.getPriority());
                    break;
                case WAITING:
                    thr.interrupt();
                    break;
                case TIMED_WAITING:
                    thr.interrupt();
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
