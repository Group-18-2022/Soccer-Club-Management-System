package za.ac.cput.controller.lookup;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.factory.lookup.KitFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KitControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private KitController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Kit kit;
    private String baseURL;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.kit = KitFactory.createKit("Home", "Blue", "Adidas");
        this.baseURL = "http://localhost:" + this.port + "/api/v1/soccer-management/kit/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<Kit> response = this.restTemplate.postForEntity(
                url, this.kit, Kit.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(2)
    void read() {
        String url = baseURL + "read/" + this.kit.getKitType();
        ResponseEntity<Kit> response = this.restTemplate.getForEntity(url, Kit.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = baseURL + "delete/" + this.kit.getKitType();
        this.restTemplate.delete(url);
    }

    @Test @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<Kit[]> response = this.restTemplate
                .getForEntity(url, Kit[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}