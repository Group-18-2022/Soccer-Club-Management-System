package za.ac.cput.impl;
/**
 * This is the Contact Information Repository
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/


import za.ac.cput.entity.ContactInformation;

import java.util.HashSet;
import java.util.Set;

public class ContactInformationRepository implements IContactInformationRepository {
    private static ContactInformationRepository contactInformationRepository = null;
    private Set<ContactInformation> contactInfoDB = null;

   private ContactInformationRepository(){
       contactInfoDB = new HashSet<>();
   }

   public static ContactInformationRepository getContactInformationRepository(){
       if(contactInformationRepository == null) contactInformationRepository = new ContactInformationRepository();

       return contactInformationRepository;
   }
    @Override
    public ContactInformation create(ContactInformation contactInformation) {

       boolean createContactInfo = contactInfoDB.add(contactInformation);
       if(!createContactInfo)return null;
       System.out.println("The Record Has Been Created.");
       return contactInformation;

    }

    @Override
    public ContactInformation read(String contactID) {
        for(ContactInformation contactInfo: contactInfoDB)
            if(contactInfo.getContactID().equals(contactID)) return contactInfo;
            return null;
    }

    @Override
    public ContactInformation update(ContactInformation contactInformation) {
       ContactInformation updateContactInfo = read(contactInformation.getContactID());

       if(updateContactInfo != null){
           contactInfoDB.remove(updateContactInfo);
           contactInfoDB.add(updateContactInfo);
           System.out.println("The Record Has Been Updated.");
           return  contactInformation;
       }
        return null;
    }

    @Override
    public boolean delete(String contactID) {
       ContactInformation deleteContactInfo = read(contactID);

       if(deleteContactInfo != null){
           contactInfoDB.remove(deleteContactInfo);
           System.out.println("The Record Has Been Deleted.");
           return true;
       }
        return false;
    }
    @Override
    public Set<ContactInformation> getAll() {
        return contactInfoDB;
    }

}
