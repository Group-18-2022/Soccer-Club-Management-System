package za.ac.cput.domain;
/**
 * This is the Contact Information entity
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public class ContactInformation {
    private String contactID;
    private String streetName;
    private String streetNumber;
    private String Area;
    private String City;
    private int zipCode;
    private String phoneNumber;
    private String emailAddress;

    public ContactInformation(ContactInfoBuilder builder) {
        this.contactID = builder.contactID;
        this.streetName = builder.streetName;;
        this.streetNumber = builder.streetNumber;
        this.Area = builder.Area;;
        this.City = builder.City;
        this.zipCode = builder.zipCode;;
        this.phoneNumber = builder.phoneNumber;
        this.emailAddress = builder.emailAddress;
    }

    public String getContactID() {
        return contactID;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getArea() {
        return Area;
    }

    public String getCity() {
        return City;
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
                "contactID:'" + contactID + '\'' +
                ", streetNumber:'" + streetNumber + '\'' +
                ", streetName:'" + streetName + '\'' +
                ", Area:'" + Area + '\'' +
                ", City:'" + City + '\'' +
                ", zipCode:" + zipCode +
                ", phoneNumber:'" + phoneNumber + '\'' +
                ", emailAddress:'" + emailAddress + '\'' +
                '}';
    }

    public static class ContactInfoBuilder{
        private String contactID;
        private String streetName;
        private String streetNumber;
        private String Area;
        private String City;
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
            Area = area;
            return this;
        }

        public ContactInfoBuilder setCity(String city) {
            City = city;
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
            this.contactID = contactInformation.contactID;
            this.streetName = contactInformation.streetName;
            this.streetNumber = contactInformation.streetNumber;
            this.Area = contactInformation.Area;
            this.City = contactInformation.City;
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
