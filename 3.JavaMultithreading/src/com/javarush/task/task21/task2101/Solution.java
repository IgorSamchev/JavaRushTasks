package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
        String address = "";
        for (byte x : netAddress){
            int  i = x & 255;
            address += i + ".";
        }

        System.out.println(address.substring(0, address.length()-1));
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] test = new byte[4];

        for (int i = 0; i < 4; i++) {
            test[i] = (byte) (ip[i] & mask[i]);
        }
        return test;
    }

    public static void print(byte[] bytes) {

        try {
            for (byte x : bytes) {
                StringBuilder s = new StringBuilder((Integer.toBinaryString(x)));

                if (s.length() < 8) {
                    while (s.length() != 8) {
                        s.insert(0, "0");
                    }
                }
                if (s.length() > 8) {
                    s = new StringBuilder(s.substring(s.length() - 8, s.length()));
                }

                System.out.print(s + " ");
            }
        } catch (Exception ignored) {
        }
        System.out.println();

    }
}
