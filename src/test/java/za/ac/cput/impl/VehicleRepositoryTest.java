package za.ac.cput.impl;

/* VehicleRepositoryTest.java
   RepositoryTest for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Vehicle;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryTest {

    private static VehicleRepository repository
            = VehicleRepository.getRepository();
    private static Vehicle vehicle
            = VehicleFactory.createVehicle("4Y1SL65848Z411439", "Bus", "Volvo", "50");

    @Test
    void create() {
        Vehicle created = repository.create(vehicle);
        assertEquals(vehicle.getVinNumber(), created.getVinNumber());
        System.out.println("Create: "+created);
    }

    @Test
    void read() {
        Vehicle read = repository.read(vehicle.getVinNumber());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void update() {
        Vehicle updated = new
                Vehicle.Builder().copy(vehicle)
                .setVinNumber("4Y1SL65848Z411437")
                .setModelType("Van")
                .setModelName("Toyota")
                .setCapacity("18")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void delete() {
        boolean success = repository.delete(vehicle.getVinNumber());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}