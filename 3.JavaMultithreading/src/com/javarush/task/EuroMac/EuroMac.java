package com.javarush.task.EuroMac;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class EuroMac {
    private double dimX;
    private double dimY;
    private double dimZ;
    private String name;
    private ArrayList<String> nc;

    public static void main(String[] args) throws IOException {
        EuroMac euroMac = new EuroMac();

        euroMac.name = "NAME " + String.valueOf(new Date().getTime() / 10000);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Set dimX: ");
        euroMac.setDimX(Double.parseDouble(reader.readLine()));
        System.out.println("Set dimY: ");
        euroMac.setDimY(Double.parseDouble(reader.readLine()));
        System.out.println("Set dimZ: ");
        euroMac.setDimZ(Double.parseDouble(reader.readLine()));

        euroMac.nc = createNC(euroMac);
        writeToFile(euroMac.nc);

        reader.close();
    }

    private static void writeToFile(ArrayList<String> nc) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D://test4.nc"));

        for (String line : nc) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    private static ArrayList<String> createNC(EuroMac euroMac) {
        ArrayList<String> arrayList = new ArrayList<>();
        double dimXCorr = 23.25;
        double dimYCorr = -25.24;
        arrayList.add(euroMac.name);
        arrayList.add("DIM " + euroMac.getDimX() + " " + euroMac.getDimY() + " " + euroMac.getDimZ());
        arrayList.add("MATERIAL steel");
        arrayList.add("PINZE 401.1000 1369.9000");
        arrayList.add("TOOL 60102 Q  15.00 0.000 ");
        arrayList.add("OFFSET X17.7533 Y30.7497");
        arrayList.add("CARICO XPIN Y325.0000");
        arrayList.add("LAVORAZIONE");
        arrayList.add("COLPO X" + (euroMac.getDimX() - dimXCorr) + " Y" + (euroMac.getDimY() - dimYCorr));
        arrayList.add("COLPO X" + (euroMac.getDimX() - dimXCorr - 11.6) + " Y" + (euroMac.getDimY() - dimYCorr));
        arrayList.add("COLPO X" + (euroMac.getDimX() - dimXCorr - 23.2) + " Y" + (euroMac.getDimY() - dimYCorr));
        arrayList.add("COLPO X" + (euroMac.getDimX() - dimXCorr - 23.2) + " Y" + (euroMac.getDimY() - dimYCorr - 14));
        arrayList.add("COLPO X" + (euroMac.getDimX() - dimXCorr - 11.6) + " Y" + (euroMac.getDimY() - dimYCorr - 14));
        arrayList.add("COLPO X" + (euroMac.getDimX() - dimXCorr) + " Y" + (euroMac.getDimY() - dimYCorr - 14));
        arrayList.add("TOOL 60101 T  7.00 ");
        arrayList.add("OFFSET X35.5067 Y-0.0000");
        arrayList.add("COLPO X" + (euroMac.getDimX() - 47.41) + " Y" + (euroMac.getDimY() - 71.7));
        arrayList.add("COLPO X" + (euroMac.getDimX() - 70.41) + " Y" + (euroMac.getDimY() - 86.7));
        arrayList.add("COLPO X" + (euroMac.getDimX() - 200 - dimXCorr) + " Y" + (euroMac.getDimY() - 13));
        arrayList.add("COLPO X" + 200 + " Y" + (euroMac.getDimY() - 13));
        arrayList.add("MOV X-24.9067 Y95.0000");
        arrayList.add("COLPO X-24.9067 Y70.7000");
        arrayList.add("TOOL 60102 Q  15.00 0.000 ");
        arrayList.add("OFFSET X17.7533 Y30.7497");
        arrayList.add("LAVORAZIONE");
        arrayList.add("COLPO X-12.2533 Y36.2497");
        arrayList.add("COLPO X-4.7533 Y36.2497");
        arrayList.add("COLPO X2.7467 Y36.2497");
        arrayList.add("COLPO X2.7467 Y49.7497");
        arrayList.add("COLPO X-4.7533 Y49.7497");
        arrayList.add("COLPO X-12.2533 Y49.7497");
        arrayList.add("TOOL 12 R  54.39 21.20 0.000 _SINGLE_");
        arrayList.add("OFFSET X0.0000 Y-0.0000");
        arrayList.add("COLPO X18.9000 Y35.1000");
        arrayList.add("MOV X18.9000 Y95.0000");
        arrayList.add("COLPO X" + (euroMac.getDimX() - 23.4) + " Y" + (euroMac.getDimY() - 35.1));
        arrayList.add("COLPO X" + (euroMac.getDimX() - 6) + " Y" + (euroMac.getDimY() - 35.1));
        arrayList.add("END");

        return arrayList;
    }

    public String getName() {
        return name;
    }

    public double getDimX() {

        return dimX;
    }

    public void setDimX(double dimX) {
        this.dimX = dimX;
    }

    public double getDimY() {
        return dimY;
    }

    public void setDimY(double dimY) {
        this.dimY = dimY;
    }

    public double getDimZ() {
        return dimZ;
    }

    public void setDimZ(double dimZ) {
        this.dimZ = dimZ;
    }


}
