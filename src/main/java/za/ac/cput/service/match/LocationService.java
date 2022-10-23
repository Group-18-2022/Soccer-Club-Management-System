package za.ac.cput.service.match;

import za.ac.cput.domain.match.Location;
import za.ac.cput.service.IService;

import java.util.List;

public interface LocationService extends IService<Location, String> {
    void deleteById(String id);
    List<Location> findAll();
}
