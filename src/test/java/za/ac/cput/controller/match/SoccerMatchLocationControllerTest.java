package za.ac.cput.controller.match;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.MatchLocation;
import za.ac.cput.factory.match.LocationFactory;
import za.ac.cput.factory.match.MatchFactory;
import za.ac.cput.factory.match.MatchLocationFactory;
import za.ac.cput.service.match.impl.LocationServiceImpl;
import za.ac.cput.service.match.impl.MatchServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SoccerMatchLocationControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private MatchServiceImpl matchService;
    @Autowired
    private LocationServiceImpl locationService;

    @Autowired
    private MatchLocationController controller;
    @Autowired private TestRestTemplate restTemplate;

    private MatchLocation matchLocation;
    private String baseURL;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.matchLocation = MatchLocationFactory.createMatchLocation("1", "1");
        this.baseURL = "http://localhost:" + this.port + "/api/v1/soccer-management/matchLocation/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        insertMatch();
        ResponseEntity<MatchLocation> response = this.restTemplate.postForEntity(
                url, this.matchLocation, MatchLocation.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }


//    @Test @Order(2)
//    void read() {
//        String url = baseURL + "read/" + new MatchLocation.MatchLocationID("1", "1");
//        ResponseEntity<MatchLocation> response = this.restTemplate.getForEntity(url, MatchLocation.class);
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertNotNull(response.getBody())
//        );
//    }

    @Test @Order(3)
    void delete() {
        String url = baseURL + "delete";
        this.restTemplate.delete(url, matchLocation);
    }

    @Test @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<MatchLocation[]> response = this.restTemplate
                .getForEntity(url, MatchLocation[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }

    private void insertMatch() {
        var soccerMatch = MatchFactory.createMatch("1", "Team R", "Away", "12 March 2022", "19:00");
        this.matchService.save(soccerMatch);
        var location = LocationFactory.createLocation("1", "Stadium A");
        this.locationService.save(location);
    }
}