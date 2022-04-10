package za.ac.cput.impl;

/*
 * @author Mponeng Ratego
 * 216178991
 */

import za.ac.cput.entity.Contract;

import java.util.HashSet;
import java.util.Set;

public class ContractRepository implements IRepositoryContract{

    private static ContractRepository repository = null;
    private Set<Contract> contractDB = null;

    private  ContractRepository () {
        contractDB = new HashSet<Contract>();
    }

    public static ContractRepository getRepository() {
        if (repository == null){
            repository = new ContractRepository();
        }
        return repository;
    }

    @Override
    public Contract create(Contract contract) {
        boolean success = contractDB.add(contract);
        if(!success)
            return null;
        return contract;
    }

    @Override
    public Contract read(LocalDate expDate) {
        Contract contract = contractDB.stream()
                .filter(e -> e.getSignedDate().equals(expDate))
                .findAny()
                .orElse(null);
        return contract;
    }

    @Override
    public Contract update(Contract contract) {
        var currentContract = read(contract.getExpDate());
        if(currentContract != null) {
            contractDB.remove(currentContract);
            contractDB.add(contract);
            return contract;
        }
        return null;
    }

    @Override
    public boolean delete(LocalDate expDate) {
        boolean isSuccessful = true;
        var contractToDelete = read(expDate);
        if(contractToDelete != null) isSuccessful = contractDB.remove(contractToDelete);
        return isSuccessful;
    }

    @Override
    public Set<Contract> getAll() {
        return contractDB;
    }
}
