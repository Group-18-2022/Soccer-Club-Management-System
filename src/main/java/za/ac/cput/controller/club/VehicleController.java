package za.ac.cput.controller.club;

/* VehicleController.java
   Controller for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.service.club.impl.VehicleServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/vehicle/")
public class VehicleController {
    private final VehicleServiceImpl vehicleService;

    @Autowired
    public VehicleController(VehicleServiceImpl service) { this.vehicleService = service; }

    @PostMapping("save")
    public ResponseEntity<Vehicle> save(@Valid @RequestBody Vehicle vehicle) {
        Vehicle newVehicle = VehicleFactory.createVehicle(vehicle.getVinNumber(), vehicle.getModelType(), vehicle.getModelName(), vehicle.getCapacity());
        return ResponseEntity.ok(vehicleService.save(newVehicle));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Vehicle> read(@PathVariable String id) {
        Vehicle readVehicle = this.vehicleService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
        return ResponseEntity.ok(readVehicle);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Vehicle vehicle) {
        this.vehicleService.delete(vehicle);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.vehicleService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Vehicle>> findAll() {
        List<Vehicle> vehicleList = this.vehicleService.findAll();
        return ResponseEntity.ok(vehicleList);
    }
}
