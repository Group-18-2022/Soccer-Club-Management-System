/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Manager;
import za.ac.cput.entity.PersonalDetails;

public class ManagerFactory
{
    public static Manager createManager(String clubName, String jobTitle, int years, PersonalDetails personalDetails)
    {
        if(personalDetails == null) //personalDetails has id number. We cannot create any type of user without the id number.
        {
            return null;
        }
        else
        return new Manager.Builder()
                .setClubName(clubName)
                .setJobTitle(jobTitle)
                .setYearsExperience(years)
                .setPersonalDetails(personalDetails)
                .build();
    }
}
