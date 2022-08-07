package za.ac.cput.factory.match;

/*
 * @author Karl Haupt (220236585)
 * SoccerMatchFactoryTest.java -> is a testing class that is used to test the MatchFactory.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.match.SoccerMatch;

import static org.junit.jupiter.api.Assertions.*;

class SoccerMatchFactoryTest {
    private SoccerMatch soccerMatch;

    @BeforeEach
    void setUp() {
        soccerMatch = MatchFactory.createMatch("test-id", "Team A", "Away Kit", "12 May 2021", "14:00");
    }

    @Test
    public void testMatchFactoryCreate() {
        assertNotNull(soccerMatch);
    }

    @Test
    public void testMatchFactoryValueOpponent() {
        assertEquals("Team A", soccerMatch.getOpponent());
    }

    @Test
    public void testMatchFactoryValueKitType() {
        assertEquals("Away Kit", soccerMatch.getKitType());
    }

    @Test
    public void testMatchFactoryValueDate() {
        assertEquals("12 May 2021", soccerMatch.getDate());
    }

    @Test
    public void testMatchFactoryValueTime() {
        assertEquals("14:00", soccerMatch.getTime());
    }

    @Test
    public void testMatchFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchFactory.createMatch(null, null, null, null, null);
        });

        String expectedMessage = "Invalid value for params: matchID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMatchFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchFactory.createMatch("", "", "", "", "");
        });

        String expectedMessage = "Invalid value for params: matchID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}