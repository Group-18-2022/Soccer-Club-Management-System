package za.ac.cput.factory;

/* SponsorFactoryTest.java
   FactoryTest for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Sponsor;

import static org.junit.jupiter.api.Assertions.*;

class SponsorFactoryTest {

    private Sponsor sponsor;

    @BeforeEach
    void setUp() {
        sponsor = SponsorFactory.createSponsor("7214607150", "KFC");
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
}