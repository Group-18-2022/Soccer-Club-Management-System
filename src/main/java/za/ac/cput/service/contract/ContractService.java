package za.ac.cput.service.contract;

import za.ac.cput.domain.contract.Contract;

import java.util.List;
import java.util.Optional;

import za.ac.cput.service.IService;

public interface ContractService extends IService<Contract, String> {
    Contract save(Contract contract);

    Optional<Contract> read(String id);

    void deleteById(String id);

    void delete(Contract contract);

    List<Contract> findAllContract();
}
