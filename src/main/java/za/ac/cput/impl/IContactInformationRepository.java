package za.ac.cput.impl;
/**
 * This is the Contact Information Repository Interface
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/

import za.ac.cput.entity.ContactInformation;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IContactInformationRepository extends IRepository<ContactInformation, String> {
    Set<ContactInformation> getAll();
}
