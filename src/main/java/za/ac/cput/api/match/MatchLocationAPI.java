package za.ac.cput.api.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.match.MatchLocation;
import za.ac.cput.service.match.impl.LocationServiceImpl;
import za.ac.cput.service.match.impl.MatchLocationServiceImpl;
import za.ac.cput.service.match.impl.MatchServiceImpl;

@Component
public class MatchLocationAPI {
    private final MatchLocationServiceImpl matchLocationService;
    private final LocationServiceImpl locationService;
    private final MatchServiceImpl matchService;

    @Autowired
    public MatchLocationAPI(MatchLocationServiceImpl matchLocationService, LocationServiceImpl locationService, MatchServiceImpl matchService) {
        this.matchLocationService = matchLocationService;
        this.locationService = locationService;
        this.matchService = matchService;
    }

    public MatchLocation save(MatchLocation matchLocation) {
        this.locationService.read(matchLocation.getLocationId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        this.matchService.read(matchLocation.getMatchId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return this.matchLocationService.save(matchLocation);
    }
}
