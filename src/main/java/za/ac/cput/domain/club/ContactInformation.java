package za.ac.cput.domain.club;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This is the Contact Information entity
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
@Entity
public class ContactInformation {
    @NotNull @Id
    private String contactId;
    @NotNull
    private String streetName;
    @NotNull
    private String streetNumber;
    @NotNull
    private String area;
    @NotNull
    private String city;
    @NotNull
    private int zipCode;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String emailAddress;

    protected  ContactInformation(){}
    public ContactInformation(ContactInfoBuilder builder) {
        this.contactId = builder.contactID;
        this.streetName = builder.streetName;;
        this.streetNumber = builder.streetNumber;
        this.area = builder.area;;
        this.city = builder.city;
        this.zipCode = builder.zipCode;;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
    }

    public String getContactId() {
        return contactId;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "contactID:'" + contactId + '\'' +
                ", streetNumber:'" + streetNumber + '\'' +
                ", streetName:'" + streetName + '\'' +
                ", Area:'" + area + '\'' +
                ", City:'" + city + '\'' +
                ", zipCode:" + zipCode +
                ", phoneNumber:'" + phoneNumber + '\'' +
                ", emailAddress:'" + emailAddress + '\'' +
                '}';
    }

    public static class ContactInfoBuilder{
        private String contactID;
        private String streetName;
        private String streetNumber;
        private String area;
        private String city;
        private int zipCode;
        private String phoneNumber;
        private String emailAddress;

        public ContactInfoBuilder setContactID(String contactID) {
            this.contactID = contactID;
            return this;
        }

        public ContactInfoBuilder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public ContactInfoBuilder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public ContactInfoBuilder setArea(String area) {
            this.area = area;
            return this;
        }

        public ContactInfoBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public ContactInfoBuilder setZipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public ContactInfoBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ContactInfoBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public ContactInfoBuilder copy(ContactInformation contactInformation){
            this.contactID = contactInformation.contactId;
            this.streetName = contactInformation.streetName;
            this.streetNumber = contactInformation.streetNumber;
            this.area = contactInformation.area;
            this.city = contactInformation.city;
            this.zipCode = contactInformation.zipCode;
            this.phoneNumber = contactInformation.phoneNumber;
            this.emailAddress = contactInformation.emailAddress;
            return this;
        }

        public ContactInformation build(){
            return new ContactInformation(this);
        }
    }
}
