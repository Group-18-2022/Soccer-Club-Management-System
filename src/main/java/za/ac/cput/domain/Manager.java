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

package za.ac.cput.domain;

public class Manager
{
    private String jobTitle;
    private String clubName;
    //private Vehicle vehicle;
    private int yearsExperience;
    PersonalDetails personalDetails;

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
        private String jobTitle;
        private String clubName;
        private int yearsExperience;
        PersonalDetails personalDetails;

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
