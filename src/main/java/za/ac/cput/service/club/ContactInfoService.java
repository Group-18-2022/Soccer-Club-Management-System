package za.ac.cput.service.club;

import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.service.IService;

import java.util.List;
/**
 * This is the Contact Information Services
 * @author Charles Moses Lemmert (220498385)
 * **/
public interface ContactInfoService extends IService<ContactInformation,String> {

    List<ContactInformation> findAllContacts();
    void deleteById(String id);

}
