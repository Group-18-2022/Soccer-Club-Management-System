/**
 * TeamStatisticsRepository.java
 * This is the TeamStatisticsRepository
 * @author Mike Somelezo Tyolani (220187568)
 * 08 April 2022
 */
package za.ac.cput.impl;

import za.ac.cput.entity.TeamStatistics;

import java.util.HashSet;
import java.util.Set;

public class TeamStatisticsRepository implements ITeamStatisticsRepository{
    private static TeamStatisticsRepository repository = null;
    private Set<TeamStatistics> teamStatisticsDB = null;

    private  TeamStatisticsRepository () {
        teamStatisticsDB = new HashSet<TeamStatistics>();
    }

    public static TeamStatisticsRepository getRepository() {
        if (repository == null){
            repository = new TeamStatisticsRepository();
        }
        return repository;

    }

    @Override
    public TeamStatistics create(TeamStatistics teamStatistics) {
        boolean success = teamStatisticsDB.add(teamStatistics);
        if(!success)
            return null;
        return teamStatistics;

    }

    @Override
    public TeamStatistics read(String teamId) {

        TeamStatistics teamStatistics = teamStatisticsDB.stream()
                .filter(e -> e.getTeamId().equals(teamId))
                .findAny()
                .orElse(null);
        return teamStatistics;
    }

    @Override
    public TeamStatistics update(TeamStatistics teamStatistics) {
        TeamStatistics oldTeamStatistics = read(teamStatistics.getTeamId());
        if (oldTeamStatistics !=null){
            teamStatisticsDB.remove(oldTeamStatistics);
            teamStatisticsDB.add(teamStatistics);
            return teamStatistics;

        }
        return null;
    }

    @Override
    public boolean delete(String teamId) {
        TeamStatistics teamStatisticsToDelete = read(teamId);
        if (teamStatisticsToDelete == null)
            return false;
        teamStatisticsDB.remove(teamStatisticsToDelete);
        return true;
    }

    @Override
    public Set<TeamStatistics> getAll() {
        return teamStatisticsDB;
    }
}
