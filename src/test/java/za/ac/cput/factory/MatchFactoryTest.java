package za.ac.cput.factory;

/*
 * @author Karl Haupt (220236585)
 * MatchFactoryTest.java -> is a testing class that is used to test the MatchFactory.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Match;
import static org.junit.jupiter.api.Assertions.*;

class MatchFactoryTest {
    private Match match;

    @BeforeEach
    void setUp() {
        match = MatchFactory.createMatch("Team A", "Away Kit", "12 May 2021", "14:00");
    }

    @Test
    public void testMatchFactoryCreate() {
        assertNotNull(match);
    }

    @Test
    public void testMatchFactoryValueOpponent() {
        assertEquals("Team A", match.getOpponent());
    }

    @Test
    public void testMatchFactoryValueKitType() {
        assertEquals("Away Kit", match.getKitType());
    }

    @Test
    public void testMatchFactoryValueDate() {
        assertEquals("12 May 2021", match.getDate());
    }

    @Test
    public void testMatchFactoryValueTime() {
        assertEquals("14:00", match.getTime());
    }

    @Test
    public void testMatchFactoryForNull() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            MatchFactory.createMatch(null, null, null, null);
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMatchFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            MatchFactory.createMatch("", "", "", "");
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}