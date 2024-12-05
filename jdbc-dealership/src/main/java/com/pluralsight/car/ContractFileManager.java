package com.pluralsight.car;

import com.pluralsight.car.models.Contract;
import com.pluralsight.car.models.LeaseContract;
import com.pluralsight.car.models.SalesContract;

import java.io.*;

public class ContractFileManager {
    public void saveContractFile(Contract contract) {
        String line;

        if (contract instanceof LeaseContract) {
            LeaseContract lease = (LeaseContract) contract;
            line = String.join("|",
                    "LEASE",
                    lease.getDate(),
                    lease.getCustomerName(),
                    lease.getCustomerEmail(),
                    String.valueOf(lease.getVehicleSold().getVin()),
                    String.valueOf(lease.getVehicleSold().getYear()),
                    lease.getVehicleSold().getMake(),
                    lease.getVehicleSold().getModel(),
                    lease.getVehicleSold().getType(),
                    lease.getVehicleSold().getColor(),
                    String.valueOf(lease.getVehicleSold().getMileage()),
                    String.valueOf(lease.getVehicleSold().getPrice()),
                    String.valueOf(lease.getLeaseFee()),  // Add lease-specific details
                    String.valueOf(lease.getExpectedEndingValue()),
                    String.valueOf(lease.getTotalPrice()),
                    String.valueOf(lease.getMonthlyPayment()),
                    lease.isFinancing() ? "YES" : "NO"
            );
        } else if (contract instanceof SalesContract) {
            SalesContract sale = (SalesContract) contract;
            line = String.join("|",
                    "SALE",
                    sale.getDate(),
                    sale.getCustomerName(),
                    sale.getCustomerEmail(),
                    String.valueOf(sale.getVehicleSold().getVin()),
                    String.valueOf(sale.getVehicleSold().getYear()),
                    sale.getVehicleSold().getMake(),
                    sale.getVehicleSold().getModel(),
                    sale.getVehicleSold().getType(),
                    sale.getVehicleSold().getColor(),
                    String.valueOf(sale.getVehicleSold().getMileage()),
                    String.valueOf(sale.getVehicleSold().getPrice()),
                    String.valueOf(sale.getProcessingFee()),  // Add sale-specific details
                    String.valueOf(sale.getTotalPrice()),
                    sale.isFinancing() ? "YES" : "NO"
            );
        } else {
            throw new IllegalArgumentException("Unsupported contract type");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/main/resources/contracts.csv", true))) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();  // Add a newline for the next record
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
