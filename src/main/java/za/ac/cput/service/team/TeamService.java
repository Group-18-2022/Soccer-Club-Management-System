package za.ac.cput.service.team;

import za.ac.cput.domain.team.Team;
import za.ac.cput.service.IService;

import java.util.List;

public interface TeamService extends IService<Team, String> {
    void deleteById(String Id);
    List<Team> findAll();
}
