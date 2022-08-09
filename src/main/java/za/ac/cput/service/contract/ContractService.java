package za.ac.cput.service.contract;

import za.ac.cput.domain.contract.Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Contract save(Contract contract);

    Optional<Contract> read(String id);

    void deleteById(String id);

    void delete(Contract contract);

    List<Contract> findAllContract();
}
