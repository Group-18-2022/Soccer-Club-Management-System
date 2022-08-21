package za.ac.cput.service.club;

/* VehicleService.java
   Service Interface for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import za.ac.cput.domain.Vehicle;
import za.ac.cput.service.IService;

import java.util.List;

public interface VehicleService extends IService<Vehicle, String> {
    void deleteByID(String vinNumber);
    List<Vehicle> findAll();
}
