package za.ac.cput.factory.club;
/**
 * This is the Club Factory Test
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.club.Club;
import za.ac.cput.factory.club.ClubFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ClubFactoryTest {
    Club club;
    @BeforeEach
    public void setUp(){
         club = ClubFactory.createClub("1","Chelsea","Roman Abramovich",true);
    }
    @Test
    public void createClubFactoryPassingTest(){
        Club club = ClubFactory.createClub("2","Super Strikers","Bob",true);
        System.out.println("Club has been created: \n" +club + "\n");
        assertNotNull(club);
    }
    @Test
    public void clubNameValueTest(){
        assertEquals("Chelsea",club.getClubName());
    }
    @Test
    public void clubOwnerValueTest(){
        assertEquals("Roman Abramovich",club.getClubOwner());
    }
    @Test
    public void clubIsARegisteredClubValueTest(){
        assertEquals(true,club.getIsRegisteredClub());

    }
    @Test
    public void failToCreateClubFactoryTest(){
        //checking validation code
        Club club = ClubFactory.createClub("2","Super Strikers",null,true);
        System.out.println("Club has not been created due to null value - return value: " +club +"\n");
        assertEquals(null,club);
    }

}