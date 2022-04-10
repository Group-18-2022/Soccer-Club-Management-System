package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * IRepositoryLocation.java -> is an interface that is used by LocationRepository.
 */

import za.ac.cput.entity.Location;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRepositoryLocation extends IRepository<Location, String> {
    Set<Location> getAll();
    boolean contains(String ID);
}
