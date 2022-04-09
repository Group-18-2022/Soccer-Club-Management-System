package za.ac.cput.impl;

import za.ac.cput.entity.Location;

import java.util.HashSet;
import java.util.Set;

public class LocationRepository implements IRepositoryLocation {
    private static LocationRepository repository;
    private Set<Location> locationDB;

    private LocationRepository() {
        this.locationDB = new HashSet<>();
    }

    public static LocationRepository getRepository() {
        if(repository == null) repository = new LocationRepository();
        return repository;
    }

    @Override
    public Location create(Location location) {
        boolean isSuccessful = locationDB.add(location);
        if(!isSuccessful) return null;
        return location;
    }

    @Override
    public Location read(String locationID) {

    }

    @Override
    public Location update(Location location) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Set<Location> getAll() {
        return null;
    }

    @Override
    public boolean contains(String ID) {
        return false;
    }
}
