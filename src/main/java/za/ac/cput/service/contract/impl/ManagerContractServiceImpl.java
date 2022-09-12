package za.ac.cput.service.contract.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contract.ManagerContract;
import za.ac.cput.repository.contract.ManagerContractRepository;

import za.ac.cput.service.contract.ManagerContractService;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerContractServiceImpl implements ManagerContractService {

    private ManagerContractRepository managerContractReposi;

    @Autowired
    public ManagerContractServiceImpl(ManagerContractRepository managerContractReposi){
        this.managerContractReposi = managerContractReposi;
    }
    @Override
    public ManagerContract save(ManagerContract managerContract) {
        return this.managerContractReposi.save(managerContract);
    }

    @Override
    public Optional<ManagerContract> read(String id) {
        return this.managerContractReposi.findById(id);
    }
    @Override
    public void deleteById(String id) {
        this.managerContractReposi.deleteById(id);
    }
    @Override
    public void delete(ManagerContract managerContract) {
        this.managerContractReposi.delete(managerContract);
    }


    @Override
    public List<ManagerContract> findAllManagerContract() {
        return this.managerContractReposi.findAll();
    }

}



