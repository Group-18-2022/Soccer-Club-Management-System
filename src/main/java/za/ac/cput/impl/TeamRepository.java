/**
 * TeamRepository.java
 * This is the TeamRepository
 * @author Mike Somelezo Tyolani (220187568)
 * 08 April 2022
 */
package za.ac.cput.impl;

import za.ac.cput.entity.Team;

import java.util.HashSet;
import java.util.Set;

public class TeamRepository implements ITeamRepository {
    private static TeamRepository repository = null;
    private Set<Team> teamDB = null;

    private  TeamRepository () {
        teamDB = new HashSet<Team>();
    }

    public static TeamRepository getRepository() {
        if (repository == null){
            repository = new TeamRepository();
        }
        return repository;

    }

    @Override
    public Team create(Team team) {
        boolean success = teamDB.add(team);
        if(!success)
            return null;
        return team;

    }

    @Override
    public Team read(String teamId) {

        Team team = teamDB.stream()
                .filter(e -> e.getTeamId().equals(teamId))
                .findAny()
                .orElse(null);
        return team;
    }

    @Override
    public Team update(Team team) {
        Team oldTeam = read(team.getTeamId());
        if (oldTeam !=null){
            teamDB.remove(oldTeam);
            teamDB.add(team);
            return team;

        }
        return null;
    }

    @Override
    public boolean delete(String teamId) {
        Team teamToDelete = read(teamId);
        if (teamToDelete == null)
            return false;
        teamDB.remove(teamToDelete);
        return true;
    }

    @Override
    public Set<Team> getAll() {
        return teamDB;
    }
}
