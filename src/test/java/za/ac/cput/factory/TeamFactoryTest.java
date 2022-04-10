/**
 * TeamFactoryTest.java
 * This is the TeamFactoryTest
 * @author Mike Somelezo Tyolani (220187568)
 * 10 April 2022
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Team;

import static org.junit.jupiter.api.Assertions.*;

class TeamFactoryTest {
    Team team;
    Team newTeam;

    @BeforeEach
    void setUp() {
        team = TeamFactory.createTeam("Super Strikers", "20", "30");
        newTeam = TeamFactory.createTeam("Super Strikers", "30", "38");
    }

    @Test
    public void testTeamFactoryNotNull() {
        System.out.println(team.toString());
        assertNotNull(team);
    }
    @Test
    public void testTeamSame() {
        assertSame(team.getTeamName(), newTeam.getTeamName());
    }

    @Test
    public void testTeamNotSame() {
        assertNotSame(team, newTeam);
    }



}