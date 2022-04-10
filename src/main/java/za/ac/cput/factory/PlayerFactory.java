/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory;

import za.ac.cput.entity.PersonalDetails;
import za.ac.cput.entity.Player;
import za.ac.cput.util.Helper;

public class PlayerFactory

{
    public static Player createPlayer (int fieldPosition, int jerseyNumber, String teamId, PersonalDetails personalDetails)
    {

        if(personalDetails == null) //personalDetails has id number. We cannot create any type of user without the id number.
        {
            return  null;
        }
        else
        return new Player.Builder()
                .setFieldPosition(fieldPosition)
                .setJerseyNumber(jerseyNumber)
                .setTeamId(teamId)
                .setPersonalDetails(personalDetails)
                .build();
    }
}
