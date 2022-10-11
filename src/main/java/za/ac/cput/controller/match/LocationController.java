package za.ac.cput.controller.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.match.Location;
import za.ac.cput.factory.match.LocationFactory;
import za.ac.cput.service.match.impl.LocationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/location/")
public class LocationController {
    private final LocationServiceImpl locationService;

    @Autowired
    public LocationController(LocationServiceImpl service) {
        this.locationService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Location> save(@Valid @RequestBody Location location) {
        Location saveLocation = LocationFactory.createLocation(location.getLocationId(), location.getStadiumName());
        return ResponseEntity.ok(locationService.save(saveLocation));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Location> read(@PathVariable String id) {
        var location = this.locationService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location Not Found"));
        return ResponseEntity.ok(location);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Location location) {
        this.locationService.delete(location);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        this.locationService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<Location>> findAll() {
        List<Location> locations = this.locationService.findAll();
        return ResponseEntity.ok(locations);
    }
}
