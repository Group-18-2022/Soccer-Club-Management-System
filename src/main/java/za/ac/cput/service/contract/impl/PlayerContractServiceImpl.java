package za.ac.cput.service.contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.contract.PlayerContract;
import za.ac.cput.repository.contract.PlayerContractRepository;


import za.ac.cput.service.contract.PlayerContractService;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerContractServiceImpl implements PlayerContractService  {

    private PlayerContractRepository playerContractReposi;

    @Autowired
    public PlayerContractServiceImpl(PlayerContractRepository playerContractReposi){
        this. playerContractReposi =  playerContractReposi;
    }
    @Override
    public PlayerContract save(PlayerContract playerContract) {
        return this.playerContractReposi.save(playerContract);
    }

    @Override
    public Optional<PlayerContract> read(String id) {
        return this.playerContractReposi.findById(id);
    }
    @Override
    public void deleteById(String id) {
        this.playerContractReposi.deleteById(id);
    }
    @Override
    public void delete(PlayerContract playerContract) {
        this.playerContractReposi.delete(playerContract);
    }

    @Override
    public List<PlayerContract> findAllPlayerContract() {
        return this.playerContractReposi.findAll();
    }

}
