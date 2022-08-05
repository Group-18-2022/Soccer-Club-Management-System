package za.ac.cput.controller.match;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.factory.match.MatchFactory;
import za.ac.cput.factory.match.MatchScoreFactory;
import za.ac.cput.service.match.impl.MatchServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SoccerMatchScoreControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private MatchServiceImpl matchService;

    @Autowired
    private MatchScoreController controller;
    @Autowired private TestRestTemplate restTemplate;

    private MatchScore matchScore;
    private String baseURL;

    @BeforeEach
    void setUp() {
        insertMatch();
        assertNotNull(controller);
        this.matchScore = MatchScoreFactory.createMatchScore("1", (byte) 4, (byte) 4);
        this.baseURL = "http://localhost:" + this.port + "/api/v1/soccer-management/matchScore/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        //insert match
        ResponseEntity<MatchScore> response = this.restTemplate.postForEntity(
                url, this.matchScore, MatchScore.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(2)
    void read() {
        String url = baseURL + "read/" + this.matchScore.getMatchID();
        ResponseEntity<MatchScore> response = this.restTemplate.getForEntity(url, MatchScore.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = baseURL + "delete/" + this.matchScore.getMatchID();
        this.restTemplate.delete(url);
    }

    @Test @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<MatchScore[]> response = this.restTemplate
                .getForEntity(url, MatchScore[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }

    private void insertMatch() {
        var soccerMatch = MatchFactory.createMatch("1", "Team R", "Away", "12 March 2022", "19:00");
        this.matchService.save(soccerMatch);
    }
}