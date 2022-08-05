package za.ac.cput.domain;

/*
 * @author Karl Haupt (220236585)
 * SoccerSoccerMatchTest.java -> is a testing class for the SoccerMatch domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.match.SoccerMatch;

import static org.junit.jupiter.api.Assertions.*;

class SoccerSoccerMatchTest {
    private SoccerMatch soccerMatch;

    @BeforeEach
    void setUp() {
        soccerMatch = new SoccerMatch.Builder().setMatchId("1")
                .setKitType("Away Kit")
                .setOpponent("Team B")
                .setDate("14 May 2022")
                .setTime("14:00").build();
    }

    @Test
    public void testMatchForNull() {
        assertNotNull(soccerMatch);
    }

    @Test
    public void testMatchIDValue() {
        assertEquals("1", soccerMatch.getMatchId());
    }

    @Test
    public void testKitTypeValue() {
        assertEquals("Away Kit", soccerMatch.getKitType());
    }

    @Test
    public void testOpponentValue() {
        assertEquals("Team B", soccerMatch.getOpponent());
    }

    @Test
    public void testDateValue() {
        assertEquals("14 May 2022", soccerMatch.getDate());
    }

    @Test
    public void testTimeValue() {
        assertEquals("14:00", soccerMatch.getTime());
    }
}