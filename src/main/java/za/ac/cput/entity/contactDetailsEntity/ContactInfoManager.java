package za.ac.cput.entity.contactDetailsEntity;
/**
 * This is the Contact Information Manager(this class is optional)
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public class ContactInfoManager {
    private final IContactBuilder builder;

    public ContactInfoManager(IContactBuilder builder) {
        this.builder = builder;
    }

    public ContactDetails constructInfo(){
        //The dummy data can be replaced by input data from the user if GUI is implemented
            builder.init();
            builder.setContactID(1);
            builder.setStreetName("LongStreet");
            builder.setStreetNumber("21A");
            builder.setArea("City Bowl");
            builder.setCity("Cape Town");
            builder.setZipCode(8001);
            builder.setPhoneNumber("012562350");
            builder.setEmailAddress("sports@soccer");
            return builder.build();
    }


}
