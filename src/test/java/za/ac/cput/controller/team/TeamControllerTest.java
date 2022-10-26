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
import za.ac.cput.factory.team.TeamFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamControllerTest {
    @LocalServerPort
    private int TeamPort;

    @Autowired
    private TeamController teamController;

    @Autowired
    private TestRestTemplate TeamRestTemp;
    private Team team;
    private  String TeamBaseUrl;
    private String SECURITY_USERNAME = "Manager";
    private String SECURITY_PASSWORD = "ManagerPassword";
    @BeforeEach
    public void startUp(){
        assertNotNull(teamController);
         team = TeamFactory.build("team-Id", "team-name", "number-of-players", "max-Number-Of-Players");
        this.TeamBaseUrl = "http://localhost:" + this.TeamPort + "/api/v1/soccer-management/team/";

    }
    @Test
    @Order(1)
    void save() {
        String saveUrl = TeamBaseUrl + "save";
        ResponseEntity<Team> saveResponse = this.TeamRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).
                postForEntity(saveUrl,this.team, Team.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test
    @Order(2)
    void read() {
        String teamBaseUrl = TeamBaseUrl + "read/" + this.team.getTeamId();
        ResponseEntity<Team> readResponse = this.TeamRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(teamBaseUrl,Team.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotEquals(null,readResponse)
        );
    }


    @Test
    @Order(3)
    void deleteById() {
        String deleteByIdUrl = TeamBaseUrl + "delete/" + this.team.getTeamId();
        this.TeamRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(deleteByIdUrl);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = TeamBaseUrl + "delete/";
        this.TeamRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(deleteUrl);
    }

    @Test
    @Order(5)
    void findAll() {
        String findAllUrl = TeamBaseUrl +"all";
        ResponseEntity<Team[]> findAllResponse = this.TeamRestTemp.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).
                getForEntity(findAllUrl,Team[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, findAllResponse.getStatusCode()),
                () -> assertNotNull(findAllResponse.getBody()),
                () -> assertTrue(findAllResponse.getBody().length == 0)

        );
    }


}