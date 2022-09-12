package za.ac.cput.service.club.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.club.Club;
import za.ac.cput.domain.club.ContactInformation;
import za.ac.cput.repository.club.ContactInformationRepository;
import za.ac.cput.service.club.ContactInfoService;

import java.util.List;
import java.util.Optional;

/**
 * This is the Contact Information Services
 * @author Charles Moses Lemmert (220498385)
 * **/
@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private ContactInformationRepository contactInfoRepo;

    @Autowired
    public ContactInfoServiceImpl(ContactInformationRepository contactInfoRepo){
        this.contactInfoRepo = contactInfoRepo;
    }

    @Override
    public ContactInformation save(ContactInformation contactInformation) {
        return this.contactInfoRepo.save(contactInformation);
    }

    @Override
    public Optional<ContactInformation> read(String id) {
        return this.contactInfoRepo.findById(id);
    }

    @Override
    public void deleteById(String id) {
        this.contactInfoRepo.deleteById(id);
    }
    @Override
    public void delete(ContactInformation contactInformation) {
        this.contactInfoRepo.delete(contactInformation);
    }

    @Override
    public List<ContactInformation> findAllContacts() {
        return this.contactInfoRepo.findAll();
    }


}
