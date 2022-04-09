package za.ac.cput.entity;

/*
 * @author Karl Haupt (220236585)
 * MatchTest.java -> is a testing class for the Match domain.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    private Match match;

    @BeforeEach
    void setUp() {
        match = new Match.Builder().setMatchId("1")
                .setKitType("Away Kit")
                .setOpponent("Team B")
                .setDate("14 May 2022")
                .setTime("14:00").build();
    }

    @Test
    public void testMatchForNull() {
        assertNotNull(match);
    }

    @Test
    public void testMatchIDValue() {
        assertEquals("1", match.getMatchId());
    }

    @Test
    public void testKitTypeValue() {
        assertEquals("Away Kit", match.getKitType());
    }

    @Test
    public void testOpponentValue() {
        assertEquals("Team B", match.getOpponent());
    }

    @Test
    public void testDateValue() {
        assertEquals("14 May 2022", match.getDate());
    }

    @Test
    public void testTimeValue() {
        assertEquals("14:00", match.getTime());
    }
}