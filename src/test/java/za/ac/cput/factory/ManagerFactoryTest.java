/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Manager;
import za.ac.cput.entity.PersonalDetails;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest
{
    private static Manager manager = null;

    @Test
    public static void createManagerTest()
    {
        PersonalDetails p = PersonalDetailsFactory.createPersonalDetails("8204195647083", "Mondli", "Langa", null, null);

        manager = ManagerFactory.createManager("Belville FC", "Marketing Manager",5, p);

        assertNotNull(manager);
        //test should pass since the details are valid
    }

    @Test
    public static void idRequisiteTest()
    {
        manager = ManagerFactory.createManager("Belville FC", "Marketing Manager",5, null);
        //since the personal details are null, the manager should also be null
        assertNull(manager);
        //the test should pass
    }

}