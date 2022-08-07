/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory.entity;

import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.domain.entity.Player;

public class PlayerFactory

{
    public static Player createPlayer (String empNumber, int fieldPosition, Integer jerseyNumber, String teamId, PersonalDetails personalDetails)
    {

        if(personalDetails == null) //personalDetails has id number. We cannot create any type of user without the id number.
        {
            return  null;
        }
        else
        return new Player.Builder()
                .setEmpNumber(empNumber)
                .setFieldPosition(fieldPosition)
                .setJerseyNumber(jerseyNumber)
                .setTeamId(teamId)
                .setPersonalDetails(personalDetails)
                .build();
    }
}
