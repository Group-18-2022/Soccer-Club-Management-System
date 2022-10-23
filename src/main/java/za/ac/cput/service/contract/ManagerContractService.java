package za.ac.cput.service.contract;

import za.ac.cput.domain.contract.ManagerContract;

import java.util.List;
import java.util.Optional;
import za.ac.cput.service.IService;

public interface ManagerContractService  extends IService<ManagerContract, String> {
    ManagerContract save(ManagerContract managerContract);

    Optional<ManagerContract> read(String id);

    void deleteById(String id);

    void delete(ManagerContract managerContract);


    List<ManagerContract> findAll();
}
