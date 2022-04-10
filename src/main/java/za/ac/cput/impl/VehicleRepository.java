package za.ac.cput.impl;

/* VehicleRepository.java
   Repository for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import za.ac.cput.entity.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class VehicleRepository implements IVehicleRepository{

    private static VehicleRepository repository = null;
    private Set<Vehicle> vehicleDB = null;

    private  VehicleRepository () {
        vehicleDB = new HashSet<Vehicle>();
    }

    public static VehicleRepository getRepository() {
        if (repository == null){
            repository = new VehicleRepository();
        }
        return repository;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        boolean success = vehicleDB.add(vehicle);
        if(!success)
            return null;
        return vehicle;
    }

    @Override
    public Vehicle read(String vinNumber) {
        Vehicle vehicle = vehicleDB.stream()
                .filter(e -> e.getVinNumber().equals(vinNumber))
                .findAny()
                .orElse(null);
        return vehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle oldVehicle = read(vehicle.getVinNumber());
        if (oldVehicle !=null){
            vehicleDB.remove(oldVehicle);
            vehicleDB.add(vehicle);
            return vehicle;
        }
        return null;
    }

    @Override
    public boolean delete(String vinNumber) {
        Vehicle vehicleToDelete = read(vinNumber);
        if (vehicleToDelete == null)
            return false;
        vehicleDB.remove(vehicleToDelete);
        return true;
    }

    @Override
    public Set<Vehicle> getAll() {
        return vehicleDB;
    }
}
