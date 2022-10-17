package za.ac.cput.controller.entity;

import za.ac.cput.domain.lookup.PersonalDetails;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class LoginDTO {
    private String name, email;

    public LoginDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public class UserCredentials {
        private String empNumber;
        private String jobTitle;
        private String clubName;
        private int yearsExperience;
        PersonalDetails personalDetails;

        public UserCredentials(String empNumber, String jobTitle, String clubName, int yearsExperience, PersonalDetails personalDetails) {
            this.empNumber = empNumber;
            this.jobTitle = jobTitle;
            this.clubName = clubName;
            this.yearsExperience = yearsExperience;
            this.personalDetails = personalDetails;
        }

        public String getEmpNumber() {
            return empNumber;
        }

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
    }
}
