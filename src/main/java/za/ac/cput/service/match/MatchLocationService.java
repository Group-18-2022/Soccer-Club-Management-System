package za.ac.cput.service.match;

import za.ac.cput.domain.match.MatchLocation;
import za.ac.cput.service.IService;

import java.util.List;

public interface MatchLocationService extends IService<MatchLocation, MatchLocation.MatchLocationID> {
    List<MatchLocation> findAll();
}
