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
        var location = locationDB.stream()
                .filter(l -> l.getLocationId().equals(locationID))
                .findAny().orElse(null);
        return location;
    }

    @Override
    public Location update(Location location) {
        var currentLocation = read(location.getLocationId());
        if(currentLocation != null) {
            locationDB.remove(currentLocation);
            locationDB.add(location);
            return location;
        }
        return null;
    }

    @Override
    public boolean delete(String locationID) {
        boolean isSuccessful = true;
        var locationToDelete = read(locationID);
        if(locationToDelete != null) isSuccessful = locationDB.remove(locationToDelete);
        return isSuccessful;
    }

    @Override
    public Set<Location> getAll() {
        return locationDB;
    }

    @Override
    public boolean contains(String locationID) {
        var location = read(locationID);
        if(location != null) return true;
        return false;
    }
}
