package za.ac.cput.service.contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contract.Contract;
import za.ac.cput.repository.contract.ContractRepository;

import za.ac.cput.service.contract.ContractService;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractReposi;

    @Autowired
    public ContractServiceImpl(ContractRepository contractReposi){
        this.contractReposi = contractReposi;
    }
    @Override
    public Contract save(Contract contract) {
        return this.contractReposi.save(contract);
    }

    @Override
    public Optional<Contract> read(String id) {
        return this.contractReposi.findById(id);
    }
    @Override
    public void deleteById(String id) {
        this.contractReposi.deleteById(id);
    }
    @Override
    public void delete(Contract contract) {
        this.contractReposi.delete(contract);
    }

    @Override
    public List<Contract> findAllContract() {
        return this.contractReposi.findAll();
    }

}
