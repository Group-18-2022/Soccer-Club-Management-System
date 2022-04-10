package za.ac.cput.impl;
/**
 * This is the Contact Information Repository Tests
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ContactInformation;
import za.ac.cput.factory.ContactInformationFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactInformationRepositoryTest {
    private static ContactInformationRepository contactInfoRepository = ContactInformationRepository.getContactInformationRepository();
    private static ContactInformation contactInformation = ContactInformationFactory.createContactInfo("15B",
            "Bertie Genade Street","Parow", "Cape Town",7500,
            "021 526 3304","superstrikers@super.com");

    @Test
    void a_createTest() {
        ContactInformation createContactInfo = contactInfoRepository.create(contactInformation);
        assertEquals(contactInformation.getContactID(),createContactInfo.getContactID());
        System.out.println("\nNew Contact Information Record Created: \n"+ createContactInfo + "\n");
    }
    @Test
    void b_readTest() {
        ContactInformation readContactInfo = contactInfoRepository.read(contactInformation.getContactID());
        assertNotNull(readContactInfo);
        System.out.println("Contact Information Record Has Been Retrieved: \n"+ readContactInfo + "\n");

    }
    @Test
    void c_update() {
        ContactInformation update = new ContactInformation.ContactInfoBuilder().copy(contactInformation)
                .setStreetNumber("12A")
                .setCity("Randontein")
                .setArea("Greenhills")
                .setZipCode(1759)
                .setPhoneNumber("012 222 6523")
                .build();
        ContactInformation updateContactInfo = contactInfoRepository.update(update);
        assertNotSame(contactInformation,updateContactInfo);
        System.out.printf("Contact Information Record: %n %s %nUpdated Contact Information Record: %n %s %n"
                ,contactInformation,updateContactInfo);
    }

    @Test
    void d_delete() {
        boolean deletingContactInfo = contactInfoRepository.delete(contactInformation.getContactID());
        assertTrue(deletingContactInfo);
        System.out.println("\nThe Record was deleted successfully: "+ deletingContactInfo + "\n");

    }

    @Test
    void e_getAll() {
        //empty set will be returned record has already been deleted
        assertNotNull(contactInfoRepository);
        System.out.println("All Contact Information Records: \n"+ contactInfoRepository.getAll());

    }
}