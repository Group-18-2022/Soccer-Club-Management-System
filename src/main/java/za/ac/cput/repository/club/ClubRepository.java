
package za.ac.cput.repository.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.club.Club;

/**
 * This is the Club Repository
 * @author Charles Moses Lemmert (220498385)
 * **/
@Repository
public interface ClubRepository extends JpaRepository<Club, String> {
}
