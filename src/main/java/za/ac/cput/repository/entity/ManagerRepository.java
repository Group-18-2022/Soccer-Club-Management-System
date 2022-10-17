/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

 */

package za.ac.cput.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.cput.domain.entity.Manager;
import za.ac.cput.factory.entity.ManagerFactory;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository <Manager, String>
{
    @Query(value = "SELECT new Manager(M.empNumber, M.clubName, M.jobTitle, M.yearsExperience, M.personalDetails) FROM Manager M WHERE M.personalDetails.firstName = :name AND M.personalDetails.contactDetails.emailAddress = :email")
    Optional <Manager> findManagerByByNameAndEmail(String name, String email);
}
