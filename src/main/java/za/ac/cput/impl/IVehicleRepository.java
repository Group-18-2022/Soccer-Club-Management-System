package za.ac.cput.impl;

/* IVehicleRepository.java
   IRepository for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import za.ac.cput.entity.Vehicle;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IVehicleRepository extends IRepository<Vehicle, String> {
    public Set<Vehicle> getAll();
}
