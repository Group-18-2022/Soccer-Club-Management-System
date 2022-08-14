package za.ac.cput.service.contract;

import za.ac.cput.domain.contract.PlayerContract;

import java.util.List;
import java.util.Optional;
import za.ac.cput.service.IService;

public interface PlayerContractService  extends IService<PlayerContract, String> {
    PlayerContract save(PlayerContract playerContract);

    Optional<PlayerContract> read(String id);

    void deleteById(String id);

    void delete(PlayerContract playerContract);

    List<PlayerContract> findAllPlayerContract();
}
