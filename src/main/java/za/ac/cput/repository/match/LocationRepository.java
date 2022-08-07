package za.ac.cput.repository.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.match.Location;

/*
 * @author Karl Haupt (220236585)
 * LocationRepository.java -> is an interface that provides CRUD operations.
 */

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
}
