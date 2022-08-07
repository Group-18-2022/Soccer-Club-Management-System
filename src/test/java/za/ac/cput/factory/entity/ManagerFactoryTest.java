/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.factory.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.entity.Manager;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.factory.entity.ManagerFactory;
import za.ac.cput.factory.lookup.PersonalDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest
{
    private static Manager manager = null;
    private PersonalDetails p;
    @BeforeEach
    void setUp()
    {p = PersonalDetailsFactory.createPersonalDetails("8204195647083", "Mondli", "Langa", null, null);}

    @Test
    public void createManagerTest()
    {
        manager = ManagerFactory.createManager("00001","Belville FC", "Marketing Manager",5, p);

        assertNotNull(manager);
        //test should pass since the details are valid
    }

    @Test
    public void idRequisiteTest()
    {
        manager = ManagerFactory.createManager("00001","Belville FC", "Marketing Manager",5, null);

        assertNull(manager);

    }

}