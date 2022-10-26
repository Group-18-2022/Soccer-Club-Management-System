package za.ac.cput.api.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.match.Location;
import za.ac.cput.domain.match.MatchLocation;
import za.ac.cput.factory.match.LocationFactory;
import za.ac.cput.factory.match.MatchFactory;
import za.ac.cput.factory.match.MatchLocationFactory;
import za.ac.cput.service.match.impl.LocationServiceImpl;
import za.ac.cput.service.match.impl.MatchLocationServiceImpl;
import za.ac.cput.service.match.impl.MatchServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SoccerMatchLocationAPITest {

    @Autowired private MatchLocationAPI api;
    @Autowired
    private LocationServiceImpl locationService;
    @Autowired
    private MatchServiceImpl matchService;

    private MatchLocation matchLocation;

    @BeforeEach
    void setUp() {
        matchLocation = MatchLocationFactory.createMatchLocation("1", "1");
        setUpDb();
    }

    private void setUpDb() {
        var location = LocationFactory.createLocation("1", "Stadium Name");
        var match = MatchFactory.createMatch("1", "Team B", "DEFAULT", "12 May 2022", "14");
        this.locationService.save(location);
        this.matchService.save(match);
    }

    @Test
    void save() {
        MatchLocation saved = this.api.save(matchLocation);
        assertNotNull(saved);
    }
}