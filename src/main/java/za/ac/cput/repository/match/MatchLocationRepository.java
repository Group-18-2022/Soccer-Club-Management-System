package za.ac.cput.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.match.MatchLocation;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationRepository.java -> is an interface that provides CRUD operations.
 */

@Repository
public interface MatchLocationRepository extends JpaRepository<MatchLocation, MatchLocation.MatchLocationID> {
}
