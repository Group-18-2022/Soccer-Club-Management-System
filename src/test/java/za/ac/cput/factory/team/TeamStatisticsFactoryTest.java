/**
 * TeamStatisticsFactoryTest.java
 * This is the TeamStatisticsFactoryTest
 * @author Mike Somelezo Tyolani (220187568)
 * 10 April 2022
 */
package za.ac.cput.factory.team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.team.TeamStatistics;

import static org.junit.jupiter.api.Assertions.*;

class TeamStatisticsFactoryTest {
    private TeamStatistics teamStatistics;

    @BeforeEach
    void setUp() {
        teamStatistics = TeamStatisticsFactory.createTeamStatistics("team-Id", "trophies-won", "matches-played");
    }

    @Test
    public void testTeamStatisticsCreation() {
        assertAll(
                () -> assertNotNull(teamStatistics),
                () -> assertNotNull(teamStatistics.getTeamId()),
                () -> assertEquals("trophies-won", teamStatistics.getTrophiesWon())
        );
    }
    @Test
    public void testTeamIdForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TeamStatisticsFactory.createTeamStatistics("","trophies-won","matches-played");
        });

        String expectedMessage = "Invalid value for params: teamId";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testTeaStatisticsForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TeamStatisticsFactory.createTeamStatistics(null,null,null);
        });

        String expectedMessage = "Invalid value for params: TeamStatistics";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}