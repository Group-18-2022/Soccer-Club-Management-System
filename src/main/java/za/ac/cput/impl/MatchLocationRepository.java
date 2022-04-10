package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationRepository.java -> is a class that performs CRUD operations on the MatchLocation domain.
 */

import za.ac.cput.entity.MatchLocation;

import java.util.HashSet;
import java.util.Set;

public class MatchLocationRepository implements IRepositoryMatchLocation {
    private static MatchLocationRepository repository = null;
    private Set<MatchLocation> matchLocationDB;

    private MatchLocationRepository() {
        this.matchLocationDB = new HashSet<>();
    }

    public static MatchLocationRepository getRepository() {
        if(repository == null) repository = new MatchLocationRepository();
        return repository;
    }

    @Override
    public MatchLocation create(MatchLocation matchLocation) {
        boolean isSuccessful = matchLocationDB.add(matchLocation);
        if(!isSuccessful) return null;
        return matchLocation;
    }

    @Override
    public MatchLocation read(String locationID) {
        var matchLocation = matchLocationDB.stream()
                .filter(m -> m.getLocationId().equals(locationID))
                .findAny().orElse(null);
        return matchLocation;
    }

    @Override
    public MatchLocation update(MatchLocation matchLocation) {
        var currentMatchLocation = read(matchLocation.getLocationId());
        if(currentMatchLocation != null) {
            matchLocationDB.remove(currentMatchLocation);
            matchLocationDB.add(matchLocation);
            return matchLocation;
        }
        return null;
    }

    @Override
    public boolean delete(String locationID) {
        boolean isSuccessful = true;
        var matchLocationToDelete = read(locationID);
        if(matchLocationToDelete != null) isSuccessful = matchLocationDB.remove(matchLocationToDelete);
        return isSuccessful;
    }

    @Override
    public Set<MatchLocation> getAllMatchLocation() {
        return matchLocationDB;
    }

    @Override
    public boolean contains(String locationID) {
        var matchLocation = read(locationID);
        if(matchLocation != null) return true;
        return false;
    }
}
