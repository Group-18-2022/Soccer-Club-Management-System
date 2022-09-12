package za.ac.cput.service.club.impl;

/* VehicleServiceImpl.java
   Service Implementation for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.club.VehicleRepository;
import za.ac.cput.service.club.VehicleService;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository repository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return this.repository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> read(String vinNumber) {
        return this.repository.findById(vinNumber);
    }

    @Override
    public void delete(Vehicle vehicle) {
        this.repository.delete(vehicle);
    }

    @Override
    public void deleteByID(String vinNumber) {
        this.repository.deleteById(vinNumber);
    }

    @Override
    public List<Vehicle> findAll() {
        return this.repository.findAll();
    }
}
