/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PersonalDetails;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.factory.PersonalDetailsFactory;
import za.ac.cput.factory.entity.PlayerFactory;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest
{
    private static Player player = null;

    @Test
    public static void createPlayerTest()
    {
        PersonalDetails p = PersonalDetailsFactory.createPersonalDetails("8506115388084", "Pele","Zino",null, null);
        //we create a new PersonalDetails object because a Player is composed of PersonalDetails
        player = PlayerFactory.createPlayer(4, null, "TeamA", p);
        //we use the object (p) as an attribute for Player.
        assertNotNull(player);
    }

    @Test
    public static void testIdRequisite()
    {
        PersonalDetails p = PersonalDetailsFactory.createPersonalDetails(null, "Pele", "Zino", null, null);

        player = PlayerFactory.createPlayer(4, null, "TeamA", p);

        assertNull(player);
    }

}