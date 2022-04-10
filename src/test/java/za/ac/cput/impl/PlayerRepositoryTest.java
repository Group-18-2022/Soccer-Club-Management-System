/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */
package za.ac.cput.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.PersonalDetails;
import za.ac.cput.entity.Player;
import za.ac.cput.factory.PersonalDetailsFactory;
import za.ac.cput.factory.PlayerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryTest
{

    private PersonalDetails personalDetails = PersonalDetailsFactory.createPersonalDetails("8506115388084", "Pele","Zino",null, null);
    private Player newPlayer = PlayerFactory.createPlayer(4, null, "TeamA", personalDetails);

    @Test
    public void addPlayerToRepoTest()
    {
        Player testPlayer = new PlayerRepository().create(newPlayer);
        assertNotNull(testPlayer);
    }

    @Test
    public void readPlayerFromRepoTest()
    {
        Player testPlayer = new PlayerRepository().read(personalDetails.getIdNumber());
        assertNotNull(testPlayer);
    }

    @Test
    public void updatePlayerInRepo()
    {
        Player testPlayer = new PlayerRepository().update(newPlayer);
        assertEquals(newPlayer, testPlayer);

    }

    @Test
    public void getAllPlayerTest()
    {
        List list = new PlayerRepository().getAllPlayers();
        int actualListSize = 1;
        assertEquals(1, list.size());
    }

    @Test
    public void deletePlayerFromRepo()
    {
        boolean b = new PlayerRepository().delete(personalDetails.getIdNumber());
        assertEquals(true, b);
    }
    
}