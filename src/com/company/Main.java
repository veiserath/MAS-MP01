package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        VehiclesManager vehiclesManager = new VehiclesManager();

        VehiclesManager.addVehicle(new Vehicle("Toyota Yaris WE 2137JP2"));
        VehiclesManager.addVehicle(new Vehicle("Toyota Prius WX 666JK"));

        Vehicle vehicleToReplace = new Vehicle("Toyota Prius WX 666JK");

        vehicleToReplace.addCarDamages("Uszkodzony tylny blotnik");

        System.out.println("====");
        System.out.println("Current car damages: " + vehicleToReplace.getCarDamages());
        vehicleToReplace.setGpsSignalStrength(100);
        System.out.println("New gps signal strength: " + vehicleToReplace.getGpsSignalStrength());
        vehicleToReplace.setCurrentRentalPricePerKilometer(3.33);
        System.out.println("Current rental price: " + vehicleToReplace.getCurrentRentalPricePerKilometer());
        System.out.println("Get current total rent price (1st tariff): " + vehicleToReplace.getRentalPrice(7.67));
        System.out.println("Get current total rent price (1st tariff): " + vehicleToReplace.getRentalPrice(15, 8.0));
        System.out.println("====");

        System.out.println(VehiclesManager.replaceVehicle(vehicleToReplace));

        VehiclesManager.changeMaxRentalPrice(10.0);
        VehiclesManager.changeMinRentalPrice(7.0);

        System.out.println("Max rent price per kilometer: " + Vehicle.getMaxRentPricePerKilometer());
        System.out.println("Min rent price per kilometer: " + Vehicle.getMinRentPricePerKilometer());

//        VehiclesManager.removeVehicle(VehiclesManager.getVehicle("Toyota Yaris WE 2137JP2"));
//        VehiclesManager.showVehicles();

        try {
            vehiclesManager.writeObjectsToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
