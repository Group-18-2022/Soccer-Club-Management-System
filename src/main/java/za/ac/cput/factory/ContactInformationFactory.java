package za.ac.cput.factory;

import za.ac.cput.entity.ContactInformation;
import za.ac.cput.util.Helper;

public class ContactInformationFactory {

    public static ContactInformation createContactInfo(String streetNumber, String streetName, String Area,
            String City, int zipCode, String phoneNumber, String emailAddress)
    {
        if(!Helper.isValidEmail(emailAddress))return null;

        String contactID = Helper.generateID();
        return new ContactInformation.ContactInfoBuilder()
                .setContactID(contactID)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setArea(Area)
                .setCity(City)
                .setZipCode(zipCode)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .build();
    }

}
