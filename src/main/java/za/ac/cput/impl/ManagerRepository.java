/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */
package za.ac.cput.impl;
/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */
import za.ac.cput.entity.Manager;
import za.ac.cput.entity.PersonalDetails;

import java.util.ArrayList;
import java.util.List;

public class ManagerRepository implements IManagerRepository
{
    private static ManagerRepository managerRepo = null;
    private List<Manager> managerList = null;

    private ManagerRepository()
    {
        managerList = new ArrayList<Manager>();
    }

    public static ManagerRepository getManagerRepository()
    {
        if(managerRepo == null)
        {
            managerRepo = new ManagerRepository();
        }
        return null;
    }

    @Override
    public Manager create(Manager manager)
    {
        boolean success = managerList.add(manager);
        if(success==true)
        {
            return manager;
        }
        return null;
    }

    @Override
    public Manager read(String idNumber)
    {
        for(Manager m : managerList)
        {
            if(m.getPersonalDetails().getIdNumber() == idNumber);
            return m;
        }
        return null;
    }

    @Override
    public Manager update(Manager manager)
    {
        Manager updatedManager = read(manager.getPersonalDetails().getIdNumber());
        if(updatedManager !=null)
        {
            managerList.remove(manager);
            managerList.add(updatedManager);
            System.out.println("Updated Successfully");
            return updatedManager;
        }
        return null;
    }

    @Override
    public boolean delete(String idNumber)
    {
        Manager manager = read(idNumber);
        if(manager == null)
        {
            return  false;
        }
        managerList.remove(manager);
        return true;
    }

    @Override
    public List<Manager> getAllManager()
    {
        return managerList;
    }
}
