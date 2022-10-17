/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

Component:
This is the Player class. It is composed of the PersonalDetails class
and other soccer player-specific attributes.
 */

package za.ac.cput.domain.entity;

import za.ac.cput.domain.lookup.PersonalDetails;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Player
{
    @NotNull
    @Id
    private String empNumber;
    @NotNull
    private int fieldPosition;
    @NotNull
    private int jerseyNumber;
    @NotNull
    private String teamId;
    @Embedded
    @NotNull
    PersonalDetails personalDetails;

    public Player(String empNumber, int fieldPosition, int jerseyNumber, String teamId, PersonalDetails personalDetails) {
        this.empNumber = empNumber;
        this.fieldPosition = fieldPosition;
        this.jerseyNumber = jerseyNumber;
        this.teamId = teamId;
        this.personalDetails = personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    protected Player()
    {
    }

    public String getEmpNumber(){return empNumber;}
    public int getFieldPosition() {
        return fieldPosition;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getTeamId() {
        return teamId;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    private Player(Builder builder)
    {
        this.empNumber = builder.empNumber;
        this.fieldPosition = builder.fieldPosition;
        this.jerseyNumber = builder.jerseyNumber;
        this.teamId = builder.teamId;
        this.personalDetails = builder.personalDetails;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fieldPosition=" + fieldPosition +
                ", jerseyNumber=" + jerseyNumber +
                ", teamId='" + teamId + '\'' +
                '}';
    }


    public static class Builder
    {
        private String empNumber;
        private int fieldPosition;
        private int jerseyNumber;
        private String teamId;
        PersonalDetails personalDetails;

        public Builder setEmpNumber(String empNumber)
        {
            this.empNumber = empNumber;
            return this;
        }
        public Builder setFieldPosition(int fieldPosition) {
            this.fieldPosition = fieldPosition;
            return this;
        }

        public Builder setJerseyNumber(int jerseyNumber) {
            this.jerseyNumber = jerseyNumber;
            return this;
        }

        public Builder setTeamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder setPersonalDetails(PersonalDetails personalDetails) {
            this.personalDetails = personalDetails;
            return this;
        }

        public Player build()
        {
            return new Player(this);
        }
    }
}
