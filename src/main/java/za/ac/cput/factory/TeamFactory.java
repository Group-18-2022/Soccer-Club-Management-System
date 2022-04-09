/**
 * TeamStatistics.java
 * This is the TeamFactory
 * @author Mike Somelezo Tyolani (220187568)
 * 04 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Team;
import za.ac.cput.util.Helper;

public class TeamFactory {
    public static Team createTeam(String teamName, String numberOfPlayers, String maxNumberOfPlayers) {

        String teamId = Helper.generateID();
        return new Team.Builder().setTeamId(teamId)
                .setTeamName(teamName)
                .setNumberOfPlayers(numberOfPlayers)
                .setMaxNumberOfPlayers(maxNumberOfPlayers)
                .build();
    }
}
