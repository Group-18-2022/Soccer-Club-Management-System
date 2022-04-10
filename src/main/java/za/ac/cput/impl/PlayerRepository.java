/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */
package za.ac.cput.impl;

import za.ac.cput.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements IPlayerRepository
{
    private static PlayerRepository playerRepository = null;
    private static List<Player> playerList = null;

    private PlayerRepository()
    {
        playerList = new ArrayList<Player>();
    }

    @Override
    public Player create(Player player)
    {
        boolean success = playerList.add(player);
        if(success==true)
        {
            return player;
        }
        return null;
    }

    @Override
    public Player read(String idNumber)
    {
        for(Player p : playerList)
        {
            if(p.getPersonalDetails().getIdNumber().equals(idNumber))
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public Player update(Player player)
    {
        Player updatedPlayer = read(player.getPersonalDetails().getIdNumber());
        if(updatedPlayer!=null)
        {
            playerList.remove(player);
            playerList.add(updatedPlayer);
            System.out.println("Updated Successfully.");
            return updatedPlayer;
        }
        return null;
    }

    @Override
    public boolean delete(String idNumber)
    {
        Player player = read(idNumber);
        if(player!= null)
        {
        playerList.remove(player);
        return true;
        }
        return false;
    }

    @Override
    public List<Player> getAllPlayers()
    {
        return playerList;
    }
}
