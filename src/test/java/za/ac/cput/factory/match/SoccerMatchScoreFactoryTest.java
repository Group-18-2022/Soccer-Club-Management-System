package za.ac.cput.factory.match;

/*
 * @author Karl Haupt (220236585)
 * SoccerMatchScoreFactoryTest.java -> is a testing class that is used to test the MatchScoreFactory.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.match.MatchScore;

import static org.junit.jupiter.api.Assertions.*;

class SoccerMatchScoreFactoryTest {
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchScoreFactory.createMatchScore(null, (byte) 0, (byte) 0);
        });

        String expectedMessage = "Invalid value for params: matchID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMatchFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchScoreFactory.createMatchScore("", (byte) 0, (byte) -1);
        });

        String expectedMessage = "Invalid value for params: matchID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMatchFactoryForNegativeScore() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatchScoreFactory.createMatchScore("test-id", (byte) 0, (byte) -1);
        });

        String expectedMessage = "Score(s) must be positive";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}