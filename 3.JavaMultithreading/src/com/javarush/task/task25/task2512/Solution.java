package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t != null) {
            t.interrupt();
        }
        Throwable throwable = e.getCause();
        if (throwable != null) {
            uncaughtException(t, throwable);
        }
        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run(){
                try {
                    throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
                } catch (Exception e) {
                   getUncaughtExceptionHandler().uncaughtException(currentThread(), e);
                }
            }
        };
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
