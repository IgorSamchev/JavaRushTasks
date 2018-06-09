package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;
    double fuel;
    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
        Car format;
        if (type == TRUCK) {
            format = new Truck(numberOfPassengers);
        } else if (type == CABRIOLET) {
            format = new Cabriolet(numberOfPassengers);
        } else {
            format = new Sedan(numberOfPassengers);
        }
        return format;
    }

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0){
            throw new RuntimeException();
        } fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
       if (canPassengersBeTransferred()){
        return numberOfPassengers;}
        else return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
            fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if (date.before(summerStart) || date.after(summerEnd)){return false;}
        return true;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred(){
       if (driverAvailable && fuel > 0){
           return true;
       } else {
           return false;
       }
    }
}