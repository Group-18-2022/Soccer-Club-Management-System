
package za.ac.cput.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Team;
import za.ac.cput.entity.TeamStatistics;
import za.ac.cput.factory.TeamFactory;
import za.ac.cput.factory.TeamStatisticsFactory;

import static org.junit.jupiter.api.Assertions.*;

class TeamStatisticsRepositoryTest {
    private static TeamStatisticsRepository repository = TeamStatisticsRepository.getRepository();
    private static TeamStatistics teamStatistics = TeamStatisticsFactory.createTeamStatistics("5", "76");

    @Test
    void a_create() {
        TeamStatistics created = repository.create(teamStatistics);
        assertEquals(teamStatistics.getTeamId(), created.getTeamId());
        System.out.println("Created"  + created);
    }

    @Test
    void b_read() {
        TeamStatistics created = repository.create(teamStatistics);
        TeamStatistics read = repository.read(created.getTeamId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        TeamStatistics updated  = new TeamStatistics.Builder().copy(teamStatistics).setTrophiesWon("8")
                .setMatchesPlayed("98")
                .build();
        assertNotSame(teamStatistics, updated);
        System.out.println("Updated" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete((teamStatistics.getTeamId()));
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repository.getAll());

    }

}