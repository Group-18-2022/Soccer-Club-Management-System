package za.ac.cput.factory;

/* VehicleFactoryTest.java
   FactoryTest for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehicle = VehicleFactory.createVehicle("4Y1SL65848Z411439", "Bus", "Volvo", "50");
    }

    @Test
    void createVehicle() {
        assertNotNull(vehicle);
    }

    @Test
    void testVinNumber() {
        assertEquals("4Y1SL65848Z411439", vehicle.getVinNumber());
    }

    @Test
    void testModelType() {
        assertEquals("Bus", vehicle.getModelType());
    }

    @Test
    void testModelName() {
        assertEquals("Volvo", vehicle.getModelName());
    }

    @Test
    void testCapacity() {
        assertEquals("50", vehicle.getCapacity());
    }
}