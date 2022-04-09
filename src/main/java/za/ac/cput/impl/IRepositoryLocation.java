package za.ac.cput.impl;

import za.ac.cput.entity.Location;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRepositoryLocation extends IRepository<Location, String> {
    Set<Location> getAll();
    boolean contains(String ID);
}
