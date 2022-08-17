package za.ac.cput.service.team;

import za.ac.cput.domain.team.TeamStatistics;
import za.ac.cput.service.IService;

import java.util.List;

public interface TeamStatisticsService extends IService<TeamStatistics, String> {
    void deleteById(String Id);
    List<TeamStatistics> findAll();
}
