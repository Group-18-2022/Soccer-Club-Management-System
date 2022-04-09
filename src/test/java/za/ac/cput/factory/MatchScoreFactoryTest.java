package za.ac.cput.factory;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreFactoryTest.java -> is a testing class that is used to test the MatchScoreFactory.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.MatchScore;
import static org.junit.jupiter.api.Assertions.*;

class MatchScoreFactoryTest {
    private MatchScore matchScore;

    @BeforeEach
    void setUp() {
        matchScore = MatchScoreFactory.createMatchScore("1", (byte) 2, (byte) 5);
    }

    @Test
    public void testMatchScoreFactoryCreate() {
        assertNotNull(matchScore);
    }

    @Test
    public void testMatchScoreFactoryValueMatchID() {
        assertEquals("1", matchScore.getMatchID());
    }

    @Test
    public void testMatchScoreFactoryValueOpponentScore() {
        assertEquals(2, matchScore.getOpponentScore());
    }

    @Test
    public void testMatchFactoryValueTeamScore() {
        assertEquals(5, matchScore.getTeamScore());
    }

    @Test
    public void testMatchFactoryForNull() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            MatchScoreFactory.createMatchScore(null, (byte) 0, (byte) 0);
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMatchFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            MatchScoreFactory.createMatchScore("", (byte) 0, (byte) -1);
        });

        String expectedMessage = "Invalid values";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}