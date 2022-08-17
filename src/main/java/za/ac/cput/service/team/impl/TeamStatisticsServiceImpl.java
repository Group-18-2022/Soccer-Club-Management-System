package za.ac.cput.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.team.TeamStatistics;
import za.ac.cput.repository.team.TeamStatisticsRepository;
import za.ac.cput.service.team.TeamStatisticsService;

import java.util.List;
import java.util.Optional;

@Service
public class TeamStatisticsServiceImpl implements TeamStatisticsService {
    private TeamStatisticsRepository repository;

    @Autowired
    public TeamStatisticsServiceImpl(TeamStatisticsRepository repository) {
        this.repository = repository;
    }

    @Override
    public TeamStatistics save(TeamStatistics teamStatistics) {
        return this.repository.save(teamStatistics);
    }

    @Override
    public Optional<TeamStatistics> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(TeamStatistics teamStatistics) {
        this.repository.delete(teamStatistics);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<TeamStatistics> findAll() {
        return this.repository.findAll();
    }

    public Optional<TeamStatistics> findTeamStatisticsByTeamId(String teamId) {
        return this.repository.findTeamStatisticsByTeamId(teamId);

    }
}