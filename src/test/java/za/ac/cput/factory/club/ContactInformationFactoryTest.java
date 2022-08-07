package za.ac.cput.factory.club;
/**
 * This is the Contact Information Factory Test
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.factory.club.ContactInformationFactory;

import static org.junit.jupiter.api.Assertions.*;

class ContactInformationFactoryTest {
    ContactInformation contactInfo;
    ContactInformation contactInformation;
    @BeforeEach
    public void setUp(){
                 contactInfo = ContactInformationFactory.createContactInfo("1","15B",
                "Bertie Genade Street","Parow", "Cape Town",7500,
                "021 526 3304","superstrikers@supers.com");
                 contactInformation = ContactInformationFactory.createContactInfo("2","12B", "Long Street","City Bowl",
                "Cape Town", 7459,"0852553658","JenniferK@clubsports.com");
    }
    @Test
    public void contactInfoFailingValidationTest(){
        //failing email validation test and object is not created.
        ContactInformation contactInfo = ContactInformationFactory.createContactInfo("1","12A", "Hanover Street","Goodwoord",
                "Cape Town", 1245, "0852635542", "JamesJ.clubsports.com");
        System.out.println("\nContact information Object has not been created due to invalid Email - return =  " + contactInfo);
        assertEquals(null, contactInfo);

    }
    @Test
    public void contactInfoPassingValidationTest(){
        //Passing email validation test and object is created.
        ContactInformation contactInfo = ContactInformationFactory.createContactInfo("1","12B", "Long Street","City Bowl",
                "Cape Town", 7459,"0852553658","AliceK@clubsports.com");
        assertNotNull(contactInfo.toString());
        System.out.println("\nContact information Object has been created:");
        System.out.println(contactInfo);
    }
    @Test
    public void contactInfoCityEqualityTest(){
        assertNotEquals(contactInfo, contactInformation);
        System.out.printf("%nObject 1: %n %s %nObject 2: %n %s %nObject 1 is not the same as Object 2",contactInfo,contactInformation);
    }



}