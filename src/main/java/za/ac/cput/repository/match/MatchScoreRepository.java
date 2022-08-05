package za.ac.cput.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.match.MatchScore;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreRepository.java -> is an interface that provides CRUD operations.
 */

@Repository
public interface MatchScoreRepository extends JpaRepository<MatchScore, String> {
}
