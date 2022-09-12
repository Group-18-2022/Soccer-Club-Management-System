package za.ac.cput.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.team.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
