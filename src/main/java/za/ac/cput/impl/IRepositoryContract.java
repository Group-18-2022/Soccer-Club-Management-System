package za.ac.cput.impl;

/*
 * @author Mponeng Ratego
 * 216178991
 */

import za.ac.cput.entity.Contract;
import za.ac.cput.repository.IRepository;



public interface IRepositoryContract extends IRepository<Contract, String> {
    public Set<Contract> getAll();
}