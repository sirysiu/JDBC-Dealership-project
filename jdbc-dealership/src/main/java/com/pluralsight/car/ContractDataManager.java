package com.pluralsight.car;

import com.pluralsight.car.models.Contract;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContractFile(contract);  // Pass the contract object directly
    }
}
