/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.factory.lookup.PersonalDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

class PersonalDetailsFactoryTest
{
    PersonalDetails newPerson = null;

    @Test
    public void createPerson()
    {

        newPerson = PersonalDetailsFactory
                .createPersonalDetails("8906129383084", "General", "Ngcobo", "12 Aug 1993", null);

        assertNotNull(newPerson);
    }

    @Test
    public void testIdRequisite()
    {
        newPerson = PersonalDetailsFactory
                .createPersonalDetails(null, "General", "Ngcobo", null, null);

        assertNull(newPerson);

        //the factory should not create the entity when the id number is null.

    }

}