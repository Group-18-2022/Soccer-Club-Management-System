/**
 * TeamStatisticsFactory.java
 * This is the TeamStatisticsFactory
 * @author Mike Somelezo Tyolani (220187568)
 * 04 April 2022
 */
package za.ac.cput.factory.team;

import za.ac.cput.domain.team.TeamStatistics;
import za.ac.cput.util.Helper;

public class TeamStatisticsFactory {
    public static TeamStatistics createTeamStatistics(String teamId, String trophiesWon, String matchesPlayed) {
        Helper.checkStringParam("teamID", teamId);
        Helper.checkStringParam("teamName", trophiesWon);
        Helper.checkStringParam("numberOfPlayers", matchesPlayed);

        return new TeamStatistics.Builder().setTeamId(teamId)
                .setTrophiesWon(trophiesWon)
                .setMatchesPlayed(matchesPlayed)
                .build();
    }
}

