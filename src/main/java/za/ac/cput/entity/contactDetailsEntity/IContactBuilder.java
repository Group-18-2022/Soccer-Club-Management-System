package za.ac.cput.entity.contactDetailsEntity;
/**
 * This is the Contact Builder
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public interface IContactBuilder {
        void init();
        void setContactID(String contactID);
        void setStreetName(String streetName);
        void setStreetNumber(String streetNumber);
        void setArea(String area);
        void setCity(String city);
        void setZipCode(int zipCode);
        void setPhoneNumber(String phoneNumber);
        void setEmailAddress(String emailAddress);
        ContactDetails build();
}
