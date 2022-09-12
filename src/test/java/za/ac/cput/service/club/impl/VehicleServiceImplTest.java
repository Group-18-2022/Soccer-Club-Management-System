package za.ac.cput.service.club.impl;

/* VehicleServiceImplTest.java
   Test Service Implementation for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.repository.club.VehicleRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceImplTest {
    private Vehicle vehicle;
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private VehicleServiceImpl service;

    @BeforeEach
    void setUp() {
        this.vehicle = VehicleFactory.createVehicle("random-number", "Bus", "Volvo", "50");
        Vehicle saved = this.service.save(this.vehicle);
        assertEquals(this.vehicle, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.vehicle);
        List<Vehicle> vehicleList = this.service.findAll();
        assertEquals(0, vehicleList.size());
    }

    @Test
    void save() {
        Vehicle saveVehicle = this.service.save(this.vehicle);
        assertEquals(this.vehicle, saveVehicle);
    }

    @Test
    void read() {
        Optional<Vehicle> read = this.service.read(vehicle.getVinNumber());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(vehicle, read.get())
        );
    }

    @Test
    void delete() {
        this.service.delete(this.vehicle);
        this.service.findAll();
    }

    @Test
    void deleteByID() {
        this.service.deleteByID(vehicle.getVinNumber());
        List<Vehicle> vehicleList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, vehicleList.size())
        );
    }
}