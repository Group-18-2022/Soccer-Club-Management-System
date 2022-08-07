package za.ac.cput.repository.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.club.ContactInformation;
/**
 * This is the Contact Information Repository
 * @author Charles Moses Lemmert (220498385)
 * **/
@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation,String> {
}
