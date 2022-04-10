/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */

package za.ac.cput.impl;

import za.ac.cput.entity.PersonalDetails;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IPersonalDetailsRepository extends IRepository<PersonalDetails, String>
{
    public List<PersonalDetails> getAllPersonDetails();
}
