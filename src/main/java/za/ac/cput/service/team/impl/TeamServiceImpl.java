package za.ac.cput.service.team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.team.Team;
import za.ac.cput.repository.team.TeamRepository;
import za.ac.cput.service.team.TeamService;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository repository;

    @Autowired
    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Team save(Team team) {
        return this.repository.save(team);
    }

    @Override
    public Optional<Team> read(String ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(Team team) {
        this.repository.delete(team);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public List<Team> findAll() {
        return this.repository.findAll();
    }

    public Optional<Team> findTeamByTeamId(String teamId) {
        return this.repository.findTeamByTeamId(teamId);

    }
}
