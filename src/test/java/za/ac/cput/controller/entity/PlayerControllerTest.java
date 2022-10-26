package za.ac.cput.controller.entity;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.factory.entity.PlayerFactory;
import za.ac.cput.factory.lookup.PersonalDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerControllerTest
{
    @LocalServerPort
    private int port;
    @Autowired
    private PlayerController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Player player;
    private String baseURL;
    private String SECURITY_USERNAME = "Manager";
    private String SECURITY_PASSWORD = "ManagerPassword";
    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        PersonalDetails pd =
                PersonalDetailsFactory.createPersonalDetails("4402018374229","Issac", "Hayes", "11 June", null);
        this.player = PlayerFactory.createPlayer
                ("1", 5, 4, "Main Team", pd);
        this.baseURL = "http://localhost:" + this.port + "/api/v1/soccer-management/player/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseURL + "save";
        ResponseEntity<Player> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(
                url, this.player, Player.class);
        assertAll(

                () -> assertNotNull(response.getBody())
        );

    }

    @Test @Order(2)
    void read() {
        String url = baseURL + "read/" + this.player.getEmpNumber();
        ResponseEntity<Player> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Player.class);
        assertAll(
                () -> assertNotEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = baseURL + "delete/" + this.player.getEmpNumber();
        this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

    @Test @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<Player[]> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Player[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }

}