/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory.entity;

import za.ac.cput.domain.entity.Manager;
import za.ac.cput.domain.lookup.PersonalDetails;

public class ManagerFactory
{
    public static Manager createManager(String empNumber, String clubName, String jobTitle, int years, PersonalDetails personalDetails)
    {
        if(personalDetails == null) //personalDetails has id number. We cannot create any type of user without the id number.
        {
            return null;
        }
        else
        return new Manager.Builder()
                .setEmpNumber(empNumber)
                .setClubName(clubName)
                .setJobTitle(jobTitle)
                .setYearsExperience(years)
                .setPersonalDetails(personalDetails)
                .build();
    }
}
