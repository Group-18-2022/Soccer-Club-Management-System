package za.ac.cput.factory.club;
/**
 * This is the Contact Information Factory
 * @author Charles Moses Lemmert (220498385)
 * 08 April 2022
 * **/
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.util.Helper;

public class ContactInformationFactory {

    public static ContactInformation createContactInfo(String streetNumber, String streetName, String Area,
                                                       String City, int zipCode, String phoneNumber, String emailAddress)
    {
        if (ValidationCheck(streetNumber, streetName, Area, City, zipCode, phoneNumber, emailAddress)) return null;

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

    private static boolean ValidationCheck(String streetNumber, String streetName, String Area, String City, int zipCode, String phoneNumber, String emailAddress) {
        if(Helper.isEmptyOrNull(streetName)|| Helper.isEmptyOrNull(streetNumber)|| Helper.isEmptyOrNull(Area)
                || Helper.isEmptyOrNull(City) || zipCode == 0 || Helper.isEmptyOrNull(phoneNumber)) return true;

        if(!Helper.isValidEmail(emailAddress)) return true;
        return false;
    }

}
