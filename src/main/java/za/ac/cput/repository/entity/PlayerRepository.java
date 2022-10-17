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
import za.ac.cput.domain.entity.Player;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository <Player, String>
{
    @Query(value = "SELECT new Player (P.empNumber, P.fieldPosition, P.jerseyNumber, P.teamId, P.personalDetails) FROM Player P WHERE P.personalDetails.firstName = :name AND P.personalDetails.contactDetails.emailAddress = :email")
    Optional<Player> findPlayerByByNameAndEmail(String name, String email);
}
