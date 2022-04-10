/**
 * TeamStatisticsTest.java
 * This is the TeamStatisticsTest
 * @author Mike Somelezo Tyolani (220187568)
 * 09 April 2022
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamStatisticsTest {
     TeamStatistics teamStatistics;

    @BeforeEach
    void setUp(){
        teamStatistics = new TeamStatistics.Builder().setTeamId("1SK125CPT")
                .setTrophiesWon("5")
                .setMatchesPlayed("54")
                .build();

    }
    @Test
    public void testTeamStatisticsForNull() {
        System.out.println(teamStatistics.toString());
        assertNotNull(teamStatistics);
    }

    @Test
    void TestTeamId() {
       TeamStatistics newTeamStatistics = new TeamStatistics.Builder().setTeamId("1CPT235SK").build();
        TeamStatistics oldTeamStatistics = new TeamStatistics.Builder().setTeamId("1SK125CPT").build();
       assertNotEquals(newTeamStatistics, oldTeamStatistics);


    }

    @Test
    void testTrophiesWon() {
        assertEquals(5, teamStatistics.getTrophiesWon());
    }

    @Test
    void testMatchesPlayed() {
        TeamStatistics newMatchesPlayed = new TeamStatistics.Builder().setMatchesPlayed("76").build();

        assertNotEquals(89, newMatchesPlayed.getMatchesPlayed());
    }
}