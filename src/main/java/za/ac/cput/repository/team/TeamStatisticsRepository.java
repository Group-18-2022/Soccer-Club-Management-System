package za.ac.cput.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.team.TeamStatistics;

@Repository
public interface TeamStatisticsRepository extends JpaRepository<TeamStatistics, String> {
}
