package za.ac.cput.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.lookup.Kit;

/*
 * @author Karl Haupt (220236585)
 * KitRepository.java -> is an interface that provides CRUD operations.
 */

@Repository
public interface KitRepository extends JpaRepository<Kit, String> {
}
