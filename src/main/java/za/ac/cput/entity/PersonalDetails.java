/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.entity;

import java.time.LocalDate;

public class PersonalDetails
{
    private String idNumber;
    private String firstName;
    private String surname;
    private LocalDate dateOfBirth;
    private ContactInformation contactDetails;

    public PersonalDetails(Builder builder)
    {
        this.idNumber = builder.idNumber;
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public ContactInformation getContactDetails() {return contactDetails;}

    public void setContactDetails(ContactInformation contactDetails) {this.contactDetails = contactDetails;}

    public static class Builder
    {
        private String idNumber;
        private String firstName;
        private String surname;
        private LocalDate dateOfBirth;
        private ContactInformation contactDetails;

        public Builder setIdNumber(String idNumber)
        {
            this.idNumber = idNumber;
            return this;
        }

        public Builder setFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder setSurname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
            return  this;
        }

        public Builder setContactDetails(ContactInformation contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        public PersonalDetails build()
        {
            return new PersonalDetails(this);
        }
    }
}
