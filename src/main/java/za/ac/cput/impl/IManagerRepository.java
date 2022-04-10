/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */

package za.ac.cput.impl;

import za.ac.cput.entity.Manager;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IManagerRepository extends IRepository<Manager, String>
{
    public List<Manager> getAllManager();
}
