package za.ac.cput.entity;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreTest.java -> is a testing class for the MatchScore domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchScoreTest {
    private MatchScore matchScore;
    byte opponentScore;
    byte teamScore;

    @BeforeEach
    void setUp() {
        opponentScore = 2;
        teamScore = 3;
        matchScore = new MatchScore.Builder()
                .setMatchID("1")
                .setOpponentScore(opponentScore)
                .setTeamScore(teamScore)
                .build();
    }

    @Test
    public void testMatchScoreForNull() {
        assertNotNull(matchScore);
    }

    @Test
    public void testMatchIDValue() {
        assertEquals("1", matchScore.getMatchID());
    }

    @Test
    public void testOpponentScoreValue() {
        assertEquals(opponentScore, matchScore.getOpponentScore());
    }

    @Test
    public void testTeamScoreValue() {
        assertEquals(teamScore, matchScore.getTeamScore());
    }
}