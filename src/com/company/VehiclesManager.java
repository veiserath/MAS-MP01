package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehiclesManager {

    private static List<Vehicle> vehicles = new ArrayList<>();

    public VehiclesManager() {
        try {
            vehicles = readObjectsFromFile();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nie istnieje baza pojazdów!");
        }
        showVehicles();
    }

    public static void addVehicle(Vehicle vehicle) {
        if (getVehicle(vehicle.getName()) == null)
            vehicles.add(vehicle);
    }

    public static Vehicle getVehicle(String name) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().equals(name)) {
                return vehicle;
            }
        }
        return null;
    }

    public static boolean replaceVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getName().equals(vehicle.getName())) {
                vehicles.set(i, vehicle);
                return true;
            }
        }
        return false;
    }

    public static void removeVehicle(Vehicle vehicleToRemove) {
        vehicles.removeIf(vehicle -> vehicle.getName().equals(vehicleToRemove.getName()));
    }

    public static void showVehicles() {
        System.out.println("Extent of the class: " + Vehicle.class.getName());
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void writeObjectsToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("vehicles.tmp");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(VehiclesManager.vehicles);
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<Vehicle> readObjectsFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("vehicles.tmp");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList<Vehicle>) objectInputStream.readObject();
    }

    public static void changeMinRentalPrice(double newMinPrice) {
        Vehicle.setMinRentPricePerKilometer(newMinPrice);
    }

    public static void changeMaxRentalPrice(double newMaxPrice) {
        Vehicle.setMaxRentPricePerKilometer(newMaxPrice);
    }


}
