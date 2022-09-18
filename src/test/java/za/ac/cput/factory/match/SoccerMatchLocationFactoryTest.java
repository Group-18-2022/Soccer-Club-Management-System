package za.ac.cput.factory.match;
/*
 * @author Karl Haupt (220236585)
 * SoccerMatchLocationFactoryTest.java -> is a testing class that is used to test the MatchLocationFactory.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.match.MatchLocation;

import static org.junit.jupiter.api.Assertions.*;

class SoccerMatchLocationFactoryTest {
    private MatchLocation matchLocation;

    @BeforeEach
    void setUp() {
        matchLocation = MatchLocationFactory.createMatchLocation("12", "1");
    }

    @Test
    public void testMatchLocationFactoryCreate() {
        assertNotNull(matchLocation);
    }

    @Test
    public void testMatchLocationFactoryValueLocationID() {
        assertEquals("12", matchLocation.getLocationId());
    }

    @Test
    public void testMatchLocationFactoryValueMatchID() {
        assertEquals("1", matchLocation.getMatchId());
    }

    @Test
    public void testMatchLocationFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchLocationFactory.createMatchLocation(null, null);
        });

        String expectedMessage = "Invalid value for params: locationID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMatchLocationFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchLocationFactory.createMatchLocation("", "");
        });

        String expectedMessage = "Invalid value for params: locationID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}