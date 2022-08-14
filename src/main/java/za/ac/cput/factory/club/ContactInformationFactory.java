package za.ac.cput.factory.club;
/**
 * This is the Contact Information Factory
 * @author Charles Moses Lemmert (220498385)
 * 08 April 2022
 * **/
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.util.Helper;

public class ContactInformationFactory {

    public static ContactInformation createContactInfo(String contactID,String streetNumber, String streetName, String Area,
                                                       String City, int zipCode, String phoneNumber, String emailAddress)
    {

        if(zipCode <= 0 || zipCode <=999){
            throw new IllegalArgumentException(
                    String.format("Invalid value for params: %s", zipCode)
            );
        }
        Helper.checkStringParam("Contact Id",contactID);
        Helper.checkStringParam("Street Number",streetNumber);
        Helper.checkStringParam("Street Name",streetName);
        Helper.checkStringParam("Area",Area);
        Helper.checkStringParam("City",City);
        Helper.checkStringParam("Phone Number",phoneNumber);
        Helper.isValidEmail(emailAddress);
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
