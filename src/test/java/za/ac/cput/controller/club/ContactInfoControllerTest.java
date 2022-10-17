package za.ac.cput.controller.club;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.club.Club;
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.factory.club.ContactInformationFactory;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the Contact information Controller Test
 * @author Charles Moses Lemmert (220498385)
 * **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactInfoControllerTest {

    @LocalServerPort
    private int localPort;
    @Autowired
    private ContactInfoController contactController;
    @Autowired private TestRestTemplate contactRestTemp;

    private ContactInformation contactInformation;
    private String contactURL;

    @BeforeEach
    public void startUp() {
        assertNotNull(contactController);
        this.contactInformation = ContactInformationFactory.createContactInfo(
                "1","12A", "Hanover Street","Goodwoord",
                "Cape Town", 1245, "0852635542", "JamesJ@clubsports.com");
        this.contactURL = "http://localhost:" + this.localPort + "/api/v1/soccer-management/ContactInformation/";
    }

    @Test
    @Order(1)
    void save() {
        String url = contactURL + "save";
        ResponseEntity<ContactInformation> saveResponse = this.contactRestTemp.postForEntity(
                url, this.contactInformation, ContactInformation.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, saveResponse.getStatusCode()),
                () -> assertNotEquals(null,saveResponse)
        );
    }

    @Test @Order(2)
    void read() {
        String url = contactURL + "read/" + this.contactInformation.getContactId();
        ResponseEntity<ContactInformation> readResponse = this.contactRestTemp.getForEntity(url, ContactInformation.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, readResponse.getStatusCode()),
                () -> assertNotNull(readResponse.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = contactURL + "delete/" + this.contactInformation.getContactId();
        this.contactRestTemp.delete(url);
    }

    @Test
    @Order(4)
    void delete() {
        String deleteUrl = contactURL + "delete";
        this.contactRestTemp.delete(deleteUrl);
    }

    @Test @Order(5)
    void findAll() {
        String url = contactURL + "all";
        ResponseEntity<Club[]> response = this.contactRestTemp
                .getForEntity(url, Club[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }
}