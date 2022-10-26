package za.ac.cput.service.entity.impl;

/* SponsorServiceImplTest.java
   Service for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Sponsor;
import za.ac.cput.factory.SponsorFactory;
import za.ac.cput.repository.entity.SponsorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SponsorServiceImplTest {

    private Sponsor sponsor;
    @Autowired
    private SponsorRepository repository;
    @Autowired
    private SponsorServiceImpl service;

    @BeforeEach
    void setUp() {
        this.sponsor = SponsorFactory.createSponsor("some-id", "721460715", "KFC");
        Sponsor saved = this.service.save(this.sponsor);
        assertEquals(this.sponsor, saved);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.sponsor);
        List<Sponsor> sponsorList = this.service.findAll();
        assertEquals(0, sponsorList.size());
    }

    @Test
    void save() {
        Sponsor saveSponsor = this.service.save(this.sponsor);
        assertEquals(this.sponsor, saveSponsor);
    }

    @Test
    void read() {
        Optional<Sponsor> read = this.service.read(sponsor.getRoleId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(sponsor, read.get())
        );
    }

    @Test
    void delete() {
        this.service.delete(this.sponsor);
        this.service.findAll();
    }

    @Test
    void deleteByID() {
        this.service.deleteByID(sponsor.getRoleId());
        List<Sponsor> sponsorList = this.service.findAll();
        assertAll(
                () -> assertEquals(0, sponsorList.size())
        );
    }
}