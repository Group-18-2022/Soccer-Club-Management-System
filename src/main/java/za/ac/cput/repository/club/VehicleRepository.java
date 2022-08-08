package za.ac.cput.repository.club;

/* VehicleRepository.java
   Repository for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 07/08/2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
