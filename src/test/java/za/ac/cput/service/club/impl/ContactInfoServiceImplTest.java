package za.ac.cput.service.club.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.factory.club.ContactInformationFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the Contact Information Services Test
 * @author Charles Moses Lemmert (220498385)
 * **/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactInfoServiceImplTest {

    private ContactInformation contactInfo;

    @Autowired
    private ContactInfoServiceImpl service;

    @BeforeEach
    public void startUp(){
        this.contactInfo = ContactInformationFactory.createContactInfo("1","12B", "Long Street","City Bowl",
                "Cape Town", 7459,"0852553658","JenniferK@clubsports.com");

    }
    @Test
    @Order(1)
    void save() {
        ContactInformation contactSaved = this.service.save(this.contactInfo);
        assertEquals(this.contactInfo, contactSaved);
    }

    @Test
    @Order(2)
    void read() {
        Optional<ContactInformation> readContact = this.service.read(contactInfo.getContactId());
        assertAll(
                () -> assertTrue(readContact.isPresent()),
                () -> assertEquals(contactInfo, readContact.get())
        );
    }

    @Test
    @Order(4)
    void deleteById() {
        this.service.deleteById(this.contactInfo.getContactId());
        List<ContactInformation> contactList = this.service.findAllContacts();
        assertEquals(0, contactList.size());
    }

    @Test
    @Order(5)
    void delete() {
        this.service.delete(this.contactInfo);
        List<ContactInformation> contactList = this.service.findAllContacts();
        assertEquals(0, contactList.size());
    }

    @Test
    @Order(3)
    void findAllClubs() {
        List<ContactInformation> contactList = this.service.findAllContacts();
        assertEquals(1,contactList.size());
    }
}