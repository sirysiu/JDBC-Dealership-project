package com.pluralsight.car;

import com.pluralsight.car.models.Contract;
import com.pluralsight.car.models.Dealership;
import com.pluralsight.car.models.LeaseContract;
import com.pluralsight.car.models.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

  private Dealership dealership;
  Scanner scanner = new Scanner(System.in);

  public UserInterface() {
  }

  private void init() {
    this.dealership = new DealershipFileManger().getDealership();
  }

  public void display() {
    init();
    boolean isRunning = true;
    while (isRunning) {
      menus();
      String input = scanner.nextLine().trim();
      switch (input) {
        case "1":
          processGetByPriceRequest();
          break;
        case "2":
          processGetByMakeModelRequest();
          break;
        case "3":
          processGetByYearRequest();
          break;
        case "4":
          processGetByColor();
          break;
        case "5":
          processGetByMileageRequest();
          break;
        case "6":
          processGetByType();
          break;
        case "7":
          processAllVehiclesRequest();
          break;
        case "8":
          processAddVehicleRequest();
          break;
        case "9":
          processRemoveVehicleRequest();
          break;
        case "0":
          processSellOrLeaseVehicleRequest();
          break;
        case "x", "X":
          isRunning = false;
      }

    }
  }

  private static void menus() {
    System.out.println(ColorCodes.BLUE + "┌───────────────────────────────────────┐");
    System.out.println(ColorCodes.BLUE + "│                Menu                   │");
    System.out.println(ColorCodes.BLUE + "│         Please Enter an Option:       │");
    System.out.println(ColorCodes.BLUE + "├───────────────────────────────────────┤");
    System.out.println(ColorCodes.GREEN + "│ [1] Vehicle By Price                  │");
    System.out.println(ColorCodes.GREEN + "│ [2] Vehicle By Make and Model         │");
    System.out.println(ColorCodes.GREEN + "│ [3] Vehicle By Year                   │");
    System.out.println(ColorCodes.GREEN + "│ [4] Vehicle By Color                  │");
    System.out.println(ColorCodes.GREEN + "│ [5] Vehicle By Mileage                │");
    System.out.println(ColorCodes.GREEN + "│ [6] Vehicle By Type                   │");
    System.out.println(ColorCodes.GREEN + "│ [7] Show All                          │");
    System.out.println(ColorCodes.GREEN + "│ [8] Add Vehicle                       │");
    System.out.println(ColorCodes.GREEN + "│ [9] Remove Vehicle                    │");
    System.out.println(ColorCodes.GREEN + "│ [0] Sell/ Lease Vehicle               │");
    System.out.println(ColorCodes.RED + "│ [x] Exit                              │");
    System.out.println(ColorCodes.BLUE + "└───────────────────────────────────────┘" + ColorCodes.RESET);
  }


  private void displayVehicles(ArrayList<Vehicle> vehicles) {
    // Check if the vehicle list is empty
    if (vehicles.isEmpty()) {
      System.out.println(ColorCodes.YELLOW + "No vehicles found." + ColorCodes.RESET);
      return;
    }

    // Print the header with color
    System.out.printf(ColorCodes.BLUE + "%-10s %-5s %-15s %-15s %-10s %-10s %-10s %-10s%n" + ColorCodes.RESET,
            "VIN", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
    System.out.println(ColorCodes.BLUE + "---------------------------------------------------------------------------------------" + ColorCodes.RESET);

    // Print each vehicle's details
    for (Vehicle vehicle : vehicles) {
      System.out.printf("%-10d %-5d %-15s %-15s %-10s %-10s %-10d $%-9.2f%n",
              vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),
              vehicle.getModel(), vehicle.getType(), vehicle.getColor(),
              vehicle.getMileage(), vehicle.getPrice());
    }
  }

  private void processGetByPriceRequest() {
    System.out.print("Enter the minimum price: ");
    double minPrice = scanner.nextDouble(); // Get user input for minimum price
    scanner.nextLine(); // Consume the newline character

    System.out.print("Enter the maximum price: ");
    double maxPrice = scanner.nextDouble(); // Get user input for maximum price
    scanner.nextLine(); // Consume the newline character

    ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice);
    displayVehicles(vehiclesByPrice); // Use the display method to print vehicles
  }


  public void processAllVehiclesRequest() {

    displayVehicles(dealership.getInventory());
  }

  private void processGetByMakeModelRequest() {
    System.out.print("Enter the make of the vehicle: ");
    String make = scanner.nextLine().trim(); // Get user input for make

    System.out.print("Enter the model of the vehicle: ");
    String model = scanner.nextLine().trim(); // Get user input for model

    ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
    displayVehicles(vehiclesByMakeModel); // Use the display method to print vehicles
  }

  private void processGetByYearRequest() {
    System.out.print("Enter the year of the vehicle: ");
    int year = scanner.nextInt(); // Get user input for year
    scanner.nextLine(); // Consume the newline character

    ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(year);
    displayVehicles(vehiclesByYear); // Use the display method to print vehicles
  }

  private void processGetByColor() {
    System.out.print("Enter the color of the vehicle: ");
    String color = scanner.nextLine().trim(); // Get user input for color

    ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
    displayVehicles(vehiclesByColor); // Use the display method to print vehicles
  }

  private void processGetByMileageRequest() {
    System.out.print("Enter the maximum mileage of the vehicle: ");
    int maxMileage = scanner.nextInt(); // Get user input for maximum mileage
    scanner.nextLine(); // Consume the newline character

    ArrayList<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(maxMileage);
    displayVehicles(vehiclesByMileage); // Use the display method to print vehicles
  }

  private void processGetByType() {
    System.out.print("Enter the type of the vehicle: ");
    String type = scanner.nextLine().trim(); // Get user input for vehicle type

    ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(type);
    displayVehicles(vehiclesByType); // Use the display method to print vehicles
  }

  private void processAddVehicleRequest() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter VIN: ");
    int vin = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    System.out.print("Enter Year: ");
    int year = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    System.out.print("Enter Make: ");
    String make = scanner.nextLine();

    System.out.print("Enter Model: ");
    String model = scanner.nextLine();

    System.out.print("Enter Type: ");
    String type = scanner.nextLine();

    System.out.print("Enter Color: ");
    String color = scanner.nextLine();

    System.out.print("Enter Mileage: ");
    int mileage = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    System.out.print("Enter Price: ");
    double price = scanner.nextDouble();
    scanner.nextLine(); // Consume the newline character

    // Create a new Vehicle object
    Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);

    // Add the new vehicle to the dealership's inventory
    dealership.addVehicle(newVehicle);

    new DealershipFileManger().saveDealership(dealership);

    System.out.println("Vehicle added successfully!");
  }

  private void processRemoveVehicleRequest() {
    System.out.print("Enter the VIN of the vehicle to remove: ");
    int vin = scanner.nextInt(); // Get user input for VIN
    scanner.nextLine(); // Consume the newline character

    boolean removed = dealership.removeVehicle(vin);

    new DealershipFileManger().saveDealership(dealership);

    if (removed) {
      System.out.println("Vehicle removed successfully!");
    } else {
      System.out.println("Vehicle with VIN " + vin + " not found.");
    }
  }

  public void processSellOrLeaseVehicleRequest() {
    System.out.println("Enter the Vin number of vehicle: ");
    int vin = scanner.nextInt();
    scanner.nextLine();

    String date = LocalDate.now().toString();

    System.out.println("Enter Name: ");
    String customerName = scanner.nextLine();

    System.out.println("Enter Email: ");
    String email = scanner.nextLine();

    System.out.println("Lease or Sale? ");
    String customerContract = scanner.nextLine();

    // Check if input is neither lease nor sale
    if (!customerContract.equalsIgnoreCase("lease") && !customerContract.equalsIgnoreCase("sale")) {
      System.out.println("Invalid option. Please enter 'lease' or 'sale'.");
      return;
    }

    Vehicle v = dealership.getInventory().stream()
            .filter(vehicle -> vehicle.getVin() == vin)
            .findFirst()
            .orElse(null);

    if (v == null) {
      System.out.println("Vehicle not found.");
      return;
    }

    double processingFee = v.getPrice() < 10000 ? 295 : 495;
    System.out.println("Would you like to finance your vehicle? ");
    String yesOrNo = scanner.nextLine();
    boolean isFinance = yesOrNo.equalsIgnoreCase("yes");

    Contract contract;
    if (customerContract.equalsIgnoreCase("lease")) {
      contract = new LeaseContract(date, customerName, email, v);
    } else {
      return;
    }

    new ContractDataManager().saveContract(contract);
  }


}


