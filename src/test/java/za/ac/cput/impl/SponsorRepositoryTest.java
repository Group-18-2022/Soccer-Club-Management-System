package za.ac.cput.impl;

/* SponsorRepositoryTest.java
   RepositoryTest for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Sponsor;
import za.ac.cput.factory.SponsorFactory;

import static org.junit.jupiter.api.Assertions.*;

class SponsorRepositoryTest {

    private static SponsorRepository repository
            = SponsorRepository.getRepository();
    private static Sponsor sponsor
            = SponsorFactory.createSponsor("7214607150", "KFC");

    @Test
    void create() {
        Sponsor created = repository.create(sponsor);
        assertEquals(sponsor.getTaxNumber(), created.getTaxNumber());
        System.out.println("Create: "+created);
    }

    @Test
    void read() {
        Sponsor read = repository.read(sponsor.getTaxNumber());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void update() {
        Sponsor updated = new
                Sponsor.Builder().copy(sponsor)
                .setTaxNumber("7214607150")
                .setCompanyName("KFC")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void delete() {
        boolean success = repository.delete(sponsor.getTaxNumber());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}