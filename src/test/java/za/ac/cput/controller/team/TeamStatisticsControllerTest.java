package za.ac.cput.controller.team;

/* Author : Mike Somelezo Tyolani
 *  Student Number: 220187568
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.team.Team;
import za.ac.cput.domain.team.TeamStatistics;
import za.ac.cput.factory.team.TeamStatisticsFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamStatisticsControllerTest {
    @LocalServerPort
    private int TeamStatisticsPort;

    @Autowired
    private TeamStatisticsController teamStatisticsController;

    @Autowired
    private TestRestTemplate TeamStatisticsRestTemp;
    private TeamStatistics teamStatistics;
    private  String TeamStatisticsBaseUrl;
    private String SECURITY_USERNAME = "Manager";
    private String SECURITY_PASSWORD = "ManagerPassword";
    @BeforeEach
    public void startUp(){
        assertNotNull(teamStatisticsController);
        teamStatistics = TeamStatisticsFactory.createTeamStatistics("team-Id", "trophies-won", "matches-played");
        this.TeamStatisticsBaseUrl = "http://localhost:" + this.TeamStatisticsPort + "/api/v1/soccer-management/team-statistics/";

    }
    @Test
    @Order(1)
    void save() {
        String saveUrl = TeamStatisticsBaseUrl + "save";
        ResponseEntity<TeamStatistics> saveResponse = this.TeamStatisticsRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).
                postForEntity(saveUrl,this.teamStatistics, TeamStatistics.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String teamStatisticsBaseUrl = TeamStatisticsBaseUrl + "read/" + this.teamStatistics.getTeamId();
        ResponseEntity<Team> readResponse = this.TeamStatisticsRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(teamStatisticsBaseUrl,Team.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotEquals(null,readResponse)
        );
    }


    @Test
    @Order(3)
    void deleteById() {
        String deleteByIdUrl = TeamStatisticsBaseUrl + "delete/" + this.teamStatistics.getTeamId();
        this.TeamStatisticsRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(deleteByIdUrl);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = TeamStatisticsBaseUrl + "delete/";
        this.TeamStatisticsRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(deleteUrl);
    }

    @Test
    @Order(5)
    void findAll() {
        String findAllUrl = TeamStatisticsBaseUrl +"all";
        ResponseEntity<TeamStatistics[]> findAllResponse = this.TeamStatisticsRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).
                getForEntity(findAllUrl,TeamStatistics[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, findAllResponse.getStatusCode()),
                () -> assertNotNull(findAllResponse.getBody()),
                () -> assertTrue(findAllResponse.getBody().length == 0)

        );
    }


}