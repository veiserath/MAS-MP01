package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Serializable {

    private final String name;
    private Integer gpsSignalStrength;
    private final List<String> carDamages;
    private static double minRentPricePerKilometer = 1.99;
    private static double maxRentPricePerKilometer = 6.80;
    private double currentRentalPricePerKilometer;


    public Vehicle(String name) {
        this.name = name;
        this.carDamages = new ArrayList<>();
        this.gpsSignalStrength = null;
        this.currentRentalPricePerKilometer = maxRentPricePerKilometer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "gpsSignalStrength=" + gpsSignalStrength +
                ", carDamages=" + carDamages +
                ", currentRentalPrice=" + currentRentalPricePerKilometer +
                ", name='" + name + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public Integer getGpsSignalStrength() {
        return gpsSignalStrength;
    }

    public void setGpsSignalStrength(Integer gpsSignalStrength) {
        this.gpsSignalStrength = gpsSignalStrength;
    }

    public List<String> getCarDamages() {
        return carDamages;
    }

    public void addCarDamages(String damage) {
        this.carDamages.add(damage);
    }

    public double getCurrentRentalPricePerKilometer() {
        return currentRentalPricePerKilometer;
    }

    public void setCurrentRentalPricePerKilometer(double currentRentalPricePerKilometer) {
        this.currentRentalPricePerKilometer = currentRentalPricePerKilometer;
    }

    //    tariff 1
    public double getRentalPrice(double kilometers) {
        return currentRentalPricePerKilometer * kilometers;
    }

    //    tariff 2
    public double getRentalPrice(int minutes, double kilometers) {
        return (currentRentalPricePerKilometer * kilometers) * 0.5 + minutes;
    }


    public static double getMinRentPricePerKilometer() {
        return minRentPricePerKilometer;
    }

    public static double getMaxRentPricePerKilometer() {
        return maxRentPricePerKilometer;
    }

    public static void setMinRentPricePerKilometer(double minRentPricePerKilometer) {
        Vehicle.minRentPricePerKilometer = minRentPricePerKilometer;
    }

    public static void setMaxRentPricePerKilometer(double maxRentPricePerKilometer) {
        Vehicle.maxRentPricePerKilometer = maxRentPricePerKilometer;
    }
}
