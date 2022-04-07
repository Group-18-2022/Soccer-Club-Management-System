package za.ac.cput.entity.contactDetailsEntity;
/**
 * This is the Contact Details entity
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public class ContactDetails {
    private String contactID;
    private String streetName;
    private String streetNumber;
    private String Area;
    private String City;
    private int zipCode;
    private String phoneNumber;
    private String emailAddress;

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setArea(String area) {
        Area = area;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "contactID:'" + contactID + '\'' +
                ", streetName:'" + streetName + '\'' +
                ", Area:'" + Area + '\'' +
                ", City:'" + City + '\'' +
                ", zipCode:'" + zipCode + '\'' +
                ", phoneNumber:'" + phoneNumber + '\'' +
                ", emailAddress:'" + emailAddress + '\'' +
                '}';
    }
}
