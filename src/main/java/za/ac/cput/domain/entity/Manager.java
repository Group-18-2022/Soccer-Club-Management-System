/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18

Component:
This is the manager class. It is composed of the PersonalDetails class
and other manager-specific attributes.
 */

package za.ac.cput.domain.entity;

import za.ac.cput.domain.lookup.PersonalDetails;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Manager
{
    @NotNull @Id
    private String empNumber;
    @NotNull
    private String jobTitle;
    @NotNull
    private String clubName;
    //private Vehicle vehicle;
    @NotNull
    private int yearsExperience;
    @Embedded
    @NotNull
    PersonalDetails personalDetails;

    public Manager(String empNumber, String jobTitle, String clubName, int yearsExperience, PersonalDetails personalDetails) {
        this.empNumber = empNumber;
        this.jobTitle = jobTitle;
        this.clubName = clubName;
        this.yearsExperience = yearsExperience;
        this.personalDetails = personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    protected Manager() {}

    public String getEmpNumber() {return empNumber;}
    public String getJobTitle() {
        return jobTitle;
    }

    public String getClubName() {
        return clubName;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    private Manager(Builder builder)
    {
        this.empNumber = builder.empNumber;
        this.jobTitle = builder.jobTitle;
        this.clubName = builder.clubName;
        this.yearsExperience = builder.yearsExperience;
        this.personalDetails = builder.personalDetails;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "jobTitle='" + jobTitle + '\'' +
                ", clubName='" + clubName + '\'' +
                ", yearsExperience=" + yearsExperience +
                ", personalDetails=" + personalDetails +
                '}';
    }

    public static class Builder
    {
        private String empNumber;
        private String jobTitle;
        private String clubName;
        private int yearsExperience;
        PersonalDetails personalDetails;

        public Builder setEmpNumber(String empNumber)
        {
            this.empNumber = empNumber;
            return this;
        }
        public Builder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder setClubName(String clubName) {
            this.clubName = clubName;
            return this;
        }

        public Builder setYearsExperience(int yearsExperience) {
            this.yearsExperience = yearsExperience;
            return this;
        }

        public Builder setPersonalDetails(PersonalDetails personalDetails) {
            this.personalDetails = personalDetails;
            return this;
        }

        public Manager build()
        {
            return new Manager(this);
        }
    }
}
