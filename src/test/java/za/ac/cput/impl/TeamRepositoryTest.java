/**
 * TTeamRepositoryTest.java
 * This is the TeamRepositoryTest
 * @author Mike Somelezo Tyolani (220187568)
 * 10 April 2022
 */
package za.ac.cput.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Team;
import za.ac.cput.factory.TeamFactory;

import static org.junit.jupiter.api.Assertions.*;

class TeamRepositoryTest {
    private static TeamRepository repository = TeamRepository.getRepository();
    private static Team team = TeamFactory.createTeam("Super Strikers", "20", "30");

    @Test
    void a_create() {
        Team created = repository.create(team);
        assertEquals(team.getTeamId(), created.getTeamId());
        System.out.println("Created"  + created);
    }

    @Test
    void b_read() {
        Team created = repository.create(team);
        Team read = repository.read(created.getTeamId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Team updated  = new Team.Builder().copy(team).setTeamName("LiverPool")
                .setNumberOfPlayers("25")
                .setMaxNumberOfPlayers("40")
                .build();
        assertNotSame(team, updated);
        System.out.println("Updated" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete((team.getTeamId()));
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repository.getAll());

    }
}