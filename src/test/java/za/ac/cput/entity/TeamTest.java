/**
 * TeamTest.java
 * This is the TeamTest
 * @author Mike Somelezo Tyolani (220187568)
 * 09 April 2022
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private Team team;

    @BeforeEach
     void setUp(){
         team = new Team.Builder().setTeamId("1SK125CPT")
                .setTeamName("Super Strikers")
                 .setNumberOfPlayers("20")
                .setMaxNumberOfPlayers("30")
                .build();

    }


    @Test
    public void testTeamForNull() {
        System.out.println(team.toString());
        assertNotNull(team);
    }

    @Test
    public void testTeamName() {
        assertEquals("Super Strikers", team.getTeamName());
    }

    @Test
    public void testMaxNumberOfPlayers() {
        assertEquals("30", team.getMaxNumberOfPlayers());
    }

}