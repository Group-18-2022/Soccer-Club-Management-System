package za.ac.cput.factory;

/* SponsorFactoryTest.java
   FactoryTest for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Sponsor;
import static org.junit.jupiter.api.Assertions.*;

class SponsorFactoryTest {

    private Sponsor sponsor;

    @BeforeEach
    void setUp() {
        sponsor = SponsorFactory.createSponsor("some-id", "7214607150", "KFC");
    }

    @Test
    void createSponsor() {
        assertNotNull(sponsor);
    }

    @Test
    void testTaxNumber() {
        assertEquals("7214607150", sponsor.getTaxNumber());
    }

    @Test
    void testCompanyName() {
        assertEquals("KFC", sponsor.getCompanyName());
    }

    @Test
    public void testSponsorFactoryForNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SponsorFactory.createSponsor(null, null, null);
        });

        String expectedMessage = "Invalid value for params: sponsorID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSponsorFactoryForEmptyString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            SponsorFactory.createSponsor("", "", "");
        });

        String expectedMessage = "Invalid value for params: sponsorID";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}