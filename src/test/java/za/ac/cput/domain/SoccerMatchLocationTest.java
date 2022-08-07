package za.ac.cput.domain;

/*
 * @author Karl Haupt (220236585)
 * SoccerMatchLocationTest.java -> is a testing class for the MatchLocation domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.MatchLocation;

import static org.junit.jupiter.api.Assertions.*;

class SoccerMatchLocationTest {
    private MatchLocation matchLocation;

    @BeforeEach
    void setUp() {
        matchLocation = new MatchLocation.Builder().setMatchId("1").setLocationId("1").build();
    }

    @Test
    public void testMatchLocationForNull() {
        assertNotNull(matchLocation);
    }

    @Test
    public void testMatchIDValue() {
        assertEquals("1", matchLocation.getMatchId());
    }

    @Test
    public void testLocationIDValue() {
        assertEquals("1", matchLocation.getLocationId());
    }
}