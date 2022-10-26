package za.ac.cput.controller.club;

/* VehicleControllerTest.java
   Controller Test for the Vehicle
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleControllerTest {
    @LocalServerPort
    private int localPort;
    @Autowired
    private VehicleController controller;
    @Autowired
    private TestRestTemplate restTemplate;

    private Vehicle vehicle;
    private String baseURL;
    private String SECURITY_USERNAME = "Manager";
    private String SECURITY_PASSWORD = "ManagerPassword";
    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.vehicle = VehicleFactory.createVehicle("random-number", "Bus", "Volvo", "50");
        this.baseURL = "http://localhost:" + this.localPort+ "/api/v1/school-management/Vehicle/";
        System.out.println(baseURL);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<Vehicle> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url,this.vehicle, Vehicle.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = baseURL + "read/" + this.vehicle.getVinNumber();
        ResponseEntity<Vehicle> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url,Vehicle.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotEquals(null,response)
        );
    }

    @Test
    @Order(3)
    void delete() {
        String url = baseURL + "delete/";
        this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

    @Test
    @Order(4)
    void deleteById() {
        String url = baseURL + "delete/" + this.vehicle.getVinNumber();
        this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

    @Test
    @Order(5)
    void findAll() {
        String url = baseURL +"all";
        ResponseEntity<Vehicle[]> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url,Vehicle[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
}