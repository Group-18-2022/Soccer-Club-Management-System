package za.ac.cput.service.club.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.club.Club;
import za.ac.cput.factory.club.ClubFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This is the Club Services Tests
 * @author Charles Moses Lemmert (220498385)
 * **/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClubServiceImplTest {
    private Club club;

    @Autowired
    private ClubServiceImpl clubService;

    @BeforeEach
    public void startUp(){
        this.club = ClubFactory.createClub("1","Super Strikers","Bob",true);

    }
    @Test
    @Order(1)
    void save() {
        Club clubSaved = this.clubService.save(this.club);
        assertEquals(this.club, clubSaved);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Club> readClub = this.clubService.read(club.getClubID());
        assertAll(
                () -> assertTrue(readClub.isPresent()),
                () -> assertEquals(club, readClub.get())
        );
    }

    @Test
    @Order(4)
    void deleteById() {
        this.clubService.deleteById(this.club.getClubID());
        List<Club> clubList = this.clubService.findAllClubs();
        assertEquals(0, clubList.size());
    }

    @Test
    @Order(5)
    void delete() {
        this.clubService.delete(this.club);
        List<Club> clubList = this.clubService.findAllClubs();
        assertEquals(0, clubList.size());
    }

    @Test
    @Order(3)
    void findAllClubs() {
        List<Club> clubList = this.clubService.findAllClubs();
        assertEquals(1,clubList.size());
    }
}