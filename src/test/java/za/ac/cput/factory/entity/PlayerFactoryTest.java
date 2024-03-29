/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.factory.lookup.PersonalDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest
{
    private static Player player = null;

    @Test
    public void createPlayerTest()
    {
        PersonalDetails p = PersonalDetailsFactory.createPersonalDetails("8506115388084", "Pele","Zino",null, null);
        //we create a new PersonalDetails object because a Player is composed of PersonalDetails
        player = PlayerFactory.createPlayer("00001",4, 0, "TeamA", p);
        //we use the object (p) as an attribute for Player.
        assertNotNull(player);
        System.out.println(player);
    }

    @Test
    public void testIdRequisite()
    {
        PersonalDetails p = PersonalDetailsFactory.createPersonalDetails(null, "Pele", "Zino", null, null);

        player = PlayerFactory.createPlayer("00001",4, 76, "TeamA", p);

        assertNull(player);
    }

}