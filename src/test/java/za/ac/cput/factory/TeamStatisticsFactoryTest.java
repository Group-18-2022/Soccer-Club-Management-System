/**
 * TeamStatisticsFactoryTest.java
 * This is the TeamStatisticsFactoryTest
 * @author Mike Somelezo Tyolani (220187568)
 * 10 April 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.TeamStatistics;

import static org.junit.jupiter.api.Assertions.*;

class TeamStatisticsFactoryTest {
    TeamStatistics teamStatistics;

    @BeforeEach
    void setUp() {
        teamStatistics = TeamStatisticsFactory.createTeamStatistics("5", "50");
    }

    @Test
    public void testTeamStatisticsFactoryNotNull() {
        System.out.println(teamStatistics.toString());
        assertNotNull(teamStatistics);

    }

    @Test
    public void testTrophies() {
        assertEquals("5", teamStatistics.getTrophiesWon());

    }

    @Test
    public void testMatchesPlayed() {
        TeamStatistics newTeamStatistics = TeamStatisticsFactory.createTeamStatistics("5", null);
        assertNull(null, newTeamStatistics.getMatchesPlayed());

    }

}