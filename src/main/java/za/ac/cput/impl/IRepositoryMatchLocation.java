package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * IRepositoryMatchLocation.java -> is an interface that is used by MatchLocationRepository.
 */

import za.ac.cput.entity.MatchLocation;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRepositoryMatchLocation extends IRepository<MatchLocation, String> {
    Set<MatchLocation> getAllMatchLocation();
    boolean contains(String LocationID);

}
