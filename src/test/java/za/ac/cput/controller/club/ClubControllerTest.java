package za.ac.cput.controller.club;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.club.Club;
import za.ac.cput.factory.club.ClubFactory;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the Club Controller Test
 * @author Charles Moses Lemmert (220498385)
 * **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClubControllerTest {
    @LocalServerPort
    private int localPort;
    @Autowired
    private ClubController clubController;
    @Autowired private TestRestTemplate clubRestTemp;

    private Club club;
    private String clubURL;

    @BeforeEach
    public void startUp() {
        assertNotNull(clubController);
        this.club = ClubFactory.createClub("1","Super Strikers","Bob",true);
        this.clubURL = "http://localhost:" + this.localPort + "/api/v1/soccer-management/club/";
    }

    @Test
    @Order(1)
    void save() {
        String url = clubURL + "save";
        ResponseEntity<Club> saveResponse = this.clubRestTemp.postForEntity(
                url, this.club, Club.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test @Order(2)
    void read() {
        String url = clubURL + "read/" + this.club.getClubID();
        ResponseEntity<Club> readResponse = this.clubRestTemp.getForEntity(url, Club.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotNull(readResponse.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = clubURL + "delete/" + this.club.getClubID();
        this.clubRestTemp.delete(url);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = clubURL + "delete";
        this.clubRestTemp.delete(deleteUrl);
    }

    @Test @Order(5)
    void findAll() {
        String url = clubURL + "all";
        ResponseEntity<Club[]> response = this.clubRestTemp
                .getForEntity(url, Club[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }

}