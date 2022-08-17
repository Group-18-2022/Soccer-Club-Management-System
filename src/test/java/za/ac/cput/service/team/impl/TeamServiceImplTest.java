package za.ac.cput.service.team.impl;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.team.Team;
import za.ac.cput.factory.team.TeamFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamServiceImplTest {

    private Team team;

    @Autowired
    private TeamServiceImpl teamService;

    @BeforeEach
    public void startUp(){
        this.team = TeamFactory.build("team-Id", "team-name", "number-of-players", "max-Number-Of-Players");
    }

    @Test
    @Order(1)
    void save() {
        Team saveTeam = this.teamService.save(team);
        assertEquals(this.team, saveTeam);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Team> readTeam = this.teamService.read(team.getTeamId());
        assertAll(
                () -> assertTrue(readTeam.isPresent()),
                () -> assertEquals(team, readTeam.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.teamService.delete(this.team);
        findAll();
    }


    void findAll(){
        List<Team> teamList = this.teamService.findAll();
        assertEquals(0, teamList.size());
    }
    @Test
    @Order(3)
    void deleteById() {
        this.teamService.deleteById(team.getTeamId());
        findAll();
    }

}