/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */
package za.ac.cput.impl;

import za.ac.cput.entity.PersonalDetails;

import java.util.ArrayList;
import java.util.List;

public class PersonalDetailsRepository implements IPersonalDetailsRepository
{
    private static PersonalDetailsRepository personalRepo = null;
    private List<PersonalDetails> personalList = null;

    private PersonalDetailsRepository()
    {
        personalList = new ArrayList<PersonalDetails>();
    }

    public static PersonalDetailsRepository getRepository()
    {
        if(personalRepo ==  null)
        {
            personalRepo = new PersonalDetailsRepository();
        }
        return null;
    }

    @Override
    public PersonalDetails create(PersonalDetails personalDetails)
    {
        boolean success = personalList.add(personalDetails);

        if(success == true)
        {
            return personalDetails;
        }
        return null;
    }

    @Override
    public PersonalDetails read(String idNumber)
    {
        for(PersonalDetails p : personalList)
        {
            if(p.getIdNumber().equals(idNumber))
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public PersonalDetails update(PersonalDetails personalDetails)
    {
        PersonalDetails newPersonalDetails = read(personalDetails.getIdNumber());
        if(newPersonalDetails != null)
        {
            personalList.remove(newPersonalDetails);
            personalList.add(personalDetails);
            System.out.println("Updated Successfully");
            return personalDetails;
        }
        return null;
    }

    @Override
    public boolean delete(String idNumber)
    {
        PersonalDetails personalDetails = read(idNumber);
        if(personalDetails == null)
        {
            return false;
        }
        else personalList.remove(personalDetails);
        return true;
    }

    @Override
    public List<PersonalDetails> getAllPersonDetails()
    {
        return personalList;
    }
}
