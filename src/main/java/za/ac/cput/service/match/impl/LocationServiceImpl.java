package za.ac.cput.service.match.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.match.Location;
import za.ac.cput.repository.match.LocationRepository;
import za.ac.cput.service.match.LocationService;

import java.util.List;
import java.util.Optional;

/*
 * @author Karl Haupt (220236585)
 * LocationServiceImpl.java -> is a class that communicates with the Location Repository
 * */

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository repository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location save(Location location) {
        return this.repository.save(location);
    }

    @Override
    public Optional<Location> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Location location) {
        this.repository.delete(location);
    }

    @Override
    public void deleteById(String ID) {
        this.repository.deleteById(ID);
    }

    @Override
    public List<Location> findAll() {
        return this.repository.findAll();
    }
}
