package za.ac.cput.service.match.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.lookup.MatchLocation;
import za.ac.cput.domain.match.SoccerMatch;
import za.ac.cput.factory.match.LocationFactory;
import za.ac.cput.factory.match.MatchFactory;
import za.ac.cput.factory.match.MatchLocationFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SoccerMatchLocationServiceImplTest {
    private MatchLocation matchLocation;

    @Autowired
    private MatchLocationServiceImpl service;

    @Autowired
    private MatchServiceImpl matchService;

    @Autowired
    private LocationServiceImpl locationService;

    @BeforeEach
    void setUp() {
        insertMatch();
        this.matchLocation = MatchLocationFactory.createMatchLocation("12", "1");
        MatchLocation saved = this.service.save(this.matchLocation);
        assertEquals(this.matchLocation, saved);
    }

    private void insertMatch() {
        var soccerMatch = MatchFactory.createMatch("1", "Team R", "Away", "12 March 2022", "19:00");
        this.matchService.save(soccerMatch);
        var location = LocationFactory.createLocation("12", "Stadium A");
        this.locationService.save(location);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.matchLocation);
        List<MatchLocation> matchLocationList = this.service.findAll();
        assertEquals(0, matchLocationList.size());
    }

    @Test
    void read() {
        Optional<MatchLocation> read = this.service.read(new MatchLocation.MatchLocationID("1", "12"));
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(matchLocation, read.get())
        );
    }

    @Test
    void findAll() {
        List<MatchLocation> matchLocationList = this.service.findAll();
        assertEquals(1, matchLocationList.size());
    }

    @Test
    void delete() {
        this.service.delete(matchLocation);
        List<MatchLocation> matchLocationList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, matchLocationList.size())
        );
    }
}