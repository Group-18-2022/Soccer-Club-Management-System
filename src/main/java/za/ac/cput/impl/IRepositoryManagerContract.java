package za.ac.cput.impl;

/*
 * @author Mponeng Ratego
 * 216178991
 */

import za.ac.cput.entity.ManagerContract;
import za.ac.cput.repository.IRepository;



public interface IRepositoryManagerContract extends IRepository<ManagerContract, String> {
    public Set<ManagerContract> getAll();
}