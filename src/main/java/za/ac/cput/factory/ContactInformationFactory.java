package za.ac.cput.factory;
/**
 * This is the Contact Information Factory
 * @author Charles Moses Lemmert (220498385)
 * 08 April 2022
 * **/
import za.ac.cput.domain.ContactInformation;
import za.ac.cput.util.Helper;

public class ContactInformationFactory {

    public static ContactInformation createContactInfo(String streetNumber, String streetName, String Area,
                                                       String City, int zipCode, String phoneNumber, String emailAddress)
    {
//        if (ValidationCheck(streetNumber, streetName, Area, City, zipCode, phoneNumber, emailAddress)) return null;

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

//    private static boolean ValidationCheck(String streetNumber, String streetName, String Area, String City, int zipCode, String phoneNumber, String emailAddress) {
//        if(Helper.isNull(streetName)|| Helper.isNull(streetNumber)|| Helper.isNull(Area)
//                || Helper.isNull(City) || zipCode == 0 || Helper.isNull(phoneNumber)) return true;
//
//        if(Helper.isEmpty(streetName)|| Helper.isEmpty(streetNumber)|| Helper.isEmpty(Area)
//                || Helper.isEmpty(City) || Helper.isEmpty(phoneNumber)) return true;
//
//        if(!Helper.isValidEmail(emailAddress)) return true;
//        return false;
//    }

}
