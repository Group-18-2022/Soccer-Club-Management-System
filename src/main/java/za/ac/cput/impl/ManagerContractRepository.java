package za.ac.cput.impl;

/*
 * @author Mponeng Ratego
 * 216178991
 */

import za.ac.cput.entity.ManagerContract;

import java.util.HashSet;
import java.util.Set;

public class ManagerContractRepository implements IRepositoryManagerContract{

    private static ManagerContractRepository repository = null;
    private Set<ManagerContract> managercontractDB = null;

    private  ManagerContractRepository () {
        managercontractDB = new HashSet<ManagerContract>();
    }

    public static ManagerContractRepository getRepository() {
        if (repository == null){
            repository = new ManagerContractRepository();
        }
        return repository;
    }

    @Override
    public ManagerContract create(ManagerContract managercontract) {
        boolean success = managercontractDB.add(managercontract);
        if(!success)
            return null;
        return managercontract;
    }

    @Override
    public Contract read(LocalDate expDate) {
        ManagerContract managercontract = managercontractDB.stream()
                .filter(e -> e.getMilestonesOnTime().equals(expDate))
                .findAny()
                .orElse(null);
        return managercontract;
    }

    @Override
    public ManagerContract update(ManagerContract managercontract) {
        var currentManagerContract = read(managercontract.getMilestonesOnTime());
        if(currentManagerContract != null) {
            managercontractDB.remove(currentManagerContract);
            managercontractDB.add(managercontract);
            return managercontract;
        }
        return null;
    }

    @Override
    public boolean delete(int milestonesOnTime) {
        boolean isSuccessful = true;
        var contractToDelete = read(milestonesOnTime);
        if(contractToDelete != null) isSuccessful = managercontractDB.remove(contractToDelete);
        return isSuccessful;
    }

    @Override
    public Set<Contract> getAll() {
        return contractDB;
    }
}