/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */

package za.ac.cput.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.entity.Manager;

public interface ManagerRepository extends JpaRepository <Manager, String>
{

}
