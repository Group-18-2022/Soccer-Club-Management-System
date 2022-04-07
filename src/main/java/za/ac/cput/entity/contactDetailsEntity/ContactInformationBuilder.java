package za.ac.cput.entity.contactDetailsEntity;
/**
 * This is the Contact Info Builder (Concrete Builder Class for club/person)
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public class ContactInformationBuilder implements IContactBuilder{
    ContactDetails contactDetails;

    @Override
    public void init() {
        contactDetails = new ContactDetails();
    }

    @Override
    public void setContactID(int contactID) {
        contactDetails.setContactID(contactID);
    }

    @Override
    public void setStreetName(String streetName) {
        contactDetails.setStreetName(streetName);
    }

    @Override
    public void setStreetNumber(String streetNumber) {
        contactDetails.setStreetNumber(streetNumber);
    }

    @Override
    public void setArea(String area) {
        contactDetails.setArea(area);
    }

    @Override
    public void setCity(String city) {
        contactDetails.setCity(city);
    }

    @Override
    public void setZipCode(int zipCode) {
        contactDetails.setZipCode(zipCode);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        contactDetails.setPhoneNumber(phoneNumber);
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        contactDetails.setEmailAddress(emailAddress);
    }

    @Override
    public ContactDetails build() {
        return contactDetails;
    }
}
