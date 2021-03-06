/**
 * TeamStatisticsFactory.java
 * This is the TeamStatisticsFactory
 * @author Mike Somelezo Tyolani (220187568)
 * 04 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.TeamStatistics;
import za.ac.cput.util.Helper;

public class TeamStatisticsFactory {
    public static TeamStatistics createTeamStatistics(String trophiesWon, String matchesPlayed) {

        String teamId = Helper.generateID();
        return new TeamStatistics.Builder().setTeamId(teamId)
                .setTrophiesWon(trophiesWon)
                .setMatchesPlayed(matchesPlayed)
                .build();
    }
}

