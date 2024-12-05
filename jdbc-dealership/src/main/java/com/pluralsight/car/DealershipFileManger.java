package com.pluralsight.car;

import com.pluralsight.car.models.Dealership;
import com.pluralsight.car.models.Vehicle;

import java.io.*;

public class DealershipFileManger {

    public Dealership getDealership() {
        Dealership dealership;
            try {
                FileReader fileReader = new FileReader("src/main/resources/WorkshopFiles/inventory.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String header = bufferedReader.readLine();
                String[] headerFields = header.split("\\|");
                dealership = new Dealership(headerFields[0], headerFields[1], headerFields[2]);

                String input;
                while ((input = bufferedReader.readLine()) != null) {
                    String[] inventoryParts = input.split("\\|");
                    int vin = Integer.parseInt(inventoryParts[0]);
                    int year = Integer.parseInt(inventoryParts[1]);
                    String make = inventoryParts[2];
                    String model = inventoryParts[3];
                    String type = inventoryParts[4];
                    String color = inventoryParts[5];
                    int mileage = Integer.parseInt(inventoryParts[6]);
                    double priceRange = Double.parseDouble(inventoryParts[7]);
                    dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, mileage, priceRange));

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        return dealership;
    }



    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/WorkshopFiles/inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write dealership information
            bufferedWriter.write(String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhone()));

            // Write vehicle inventory
            for (Vehicle vehicle : dealership.getInventory()) {
                bufferedWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getType(),
                        vehicle.getColor(),
                        vehicle.getMileage(),
                        vehicle.getPrice()));
            }

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
