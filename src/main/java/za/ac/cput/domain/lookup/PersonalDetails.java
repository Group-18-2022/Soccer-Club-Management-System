/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Assignment 1
Group: 18
 */

package za.ac.cput.domain.lookup;

import za.ac.cput.domain.club.ContactInformation;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Embeddable
public class PersonalDetails
{
    @NotNull
    private String idNumber;
    @NotNull
    private String firstName;
    @NotNull
    private String surname;
    @NotNull
    private String dateOfBirth;
    @OneToOne
    @NotNull
    private ContactInformation contactDetails;

    protected PersonalDetails() {
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public ContactInformation getContactDetails() {
        return contactDetails;
    }


    @Override
    public String toString() {
        return "PersonalDetails{" +
                "idNumber='" + idNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", contactDetails=" + contactDetails +
                '}';
    }

    private PersonalDetails(Builder builder)
    {
        this.idNumber = builder.idNumber;
        this.firstName = builder.firstName;
        this.surname = builder.surname;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public static class Builder
    {
        private String idNumber;
        private String firstName;
        private String surname;
        private String dateOfBirth;
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

        public Builder setDateOfBirth(String dateOfBirth)
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
