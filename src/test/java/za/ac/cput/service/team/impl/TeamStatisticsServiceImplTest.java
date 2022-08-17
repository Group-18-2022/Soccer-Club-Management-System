package za.ac.cput.service.team.impl;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.team.TeamStatistics;
import za.ac.cput.factory.team.TeamStatisticsFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamStatisticsServiceImplTest {

    private TeamStatistics teamStatistics;

    @Autowired
    private TeamStatisticsServiceImpl teamStatisticsService;

    @BeforeEach
    public void startUp(){
        this.teamStatistics = TeamStatisticsFactory.createTeamStatistics("team-Id", "trophies-won", "matches-played");
    }

    @Test
    @Order(1)
    void save() {
        TeamStatistics saveTeamStatistics= this.teamStatisticsService.save(teamStatistics);
        assertEquals(this.teamStatistics, saveTeamStatistics);
    }

    @Test
    @Order(2)
    void read() {
        Optional<TeamStatistics> readTeamStatistics = this.teamStatisticsService.read(teamStatistics.getTeamId());
        assertAll(
                () -> assertTrue(readTeamStatistics.isPresent()),
                () -> assertEquals(teamStatistics, readTeamStatistics.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.teamStatisticsService.delete(this.teamStatistics);
        findAll();
    }


    void findAll(){
        List<TeamStatistics> teamStatisticsList = this.teamStatisticsService.findAll();
        assertEquals(0, teamStatisticsList.size());
    }
    @Test
    @Order(3)
    void deleteById() {
        this.teamStatisticsService.deleteById(teamStatistics.getTeamId());
        findAll();
    }

}