package za.ac.cput.domain;

/*
 * @author Karl Haupt (220236585)
 * SoccerMatchScoreTest.java -> is a testing class for the MatchScore domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.match.MatchScore;

import static org.junit.jupiter.api.Assertions.*;

class SoccerMatchScoreTest {
    private MatchScore matchScore;
    byte opponentScore;
    byte teamScore;

    @BeforeEach
    void setUp() {
        opponentScore = 2;
        teamScore = 3;
        matchScore = new MatchScore.Builder()
                .setMatchId("1")
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
        assertEquals("1", matchScore.getMatchId());
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