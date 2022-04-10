package za.ac.cput.factory;

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