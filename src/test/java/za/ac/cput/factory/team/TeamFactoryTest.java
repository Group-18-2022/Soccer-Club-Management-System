/**
 * TeamFactoryTest.java
 * This is the TeamFactoryTest
 * @author Mike Somelezo Tyolani (220187568)
 * 10 April 2022
 */
package za.ac.cput.factory.team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.team.Team;

import static org.junit.jupiter.api.Assertions.*;

class TeamFactoryTest {
    private Team team;

    @BeforeEach
    void setUp() {
        team = TeamFactory.build("team-Id", "team-name", "number-of-players", "max-Number-Of-Players");
    }

    @Test
    public void testTeamCreation() {
        assertAll(
                () -> assertNotNull(team),
                () -> assertNotNull(team.getTeamId()),
                () -> assertEquals("team-name", team.getTeamName())
        );
    }
    @Test
    public void testTeamIdForEmptyString() {
       Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           TeamFactory.build("","team-name","number-of-players","max-Number-Of-Players");
       });

       String expectedMessage = "Invalid value for params: teamId";
       String actualMessage = exception.getMessage();

       assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testTeamForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TeamFactory.build(null,null,null,null);
        });

        String expectedMessage = "Invalid value for params: Team";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }



}