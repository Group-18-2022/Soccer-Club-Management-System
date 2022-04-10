package za.ac.cput.impl;
/**
 * This is the Club Repository Test
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Club;
import za.ac.cput.factory.ClubFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ClubRespositoryTest {
    private static ClubRespository clubRespository = ClubRespository.getClubRespository();
    private static Club club = ClubFactory.createClub("Chelsea","Roman Abramovich",true);


    @Test
    void a_create() {
        Club createClub = clubRespository.create(club);
        assertEquals(club.getClubID(),createClub.getClubID());
        System.out.println("New Club Record Created: \n"+ createClub + "\n");
    }

    @Test
    void b_read() {
        Club readClub = clubRespository.read(club.getClubID());
        assertNotNull(readClub);
        System.out.println("Club Record Has Been Retrieved: \n"+ readClub + "\n");
    }

    @Test
    void c_update() {
        Club updateClub = new Club.ClubBuilder().copy(club)
                .setClubOwner("James Lukas")
                .setRegisteredClub(false)
                .build();

        assertNotSame(club,updateClub);
        System.out.printf("Club Record: %n %s %nUpdated Club Record: %n %s %n"
                ,club,updateClub);
    }

    @Test
    void d_delete() {
        boolean deletingClub = clubRespository.delete(club.getClubID());
        assertTrue(deletingClub);
        System.out.println("\nThe Record was deleted successfully: "+ deletingClub + "\n");
    }

    @Test
    void e_getAll() {
        //empty set will be returned record has already been deleted
        assertNotNull(clubRespository);
        System.out.println("All Club Records: \n"+ clubRespository.getAll());
    }
}