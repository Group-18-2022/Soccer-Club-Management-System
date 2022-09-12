/**
 * TeamFactory.java
 * This is the TeamFactory
 * @author Mike Somelezo Tyolani (220187568)
 * 04 April 2022
 */
package za.ac.cput.factory.team;

import za.ac.cput.domain.team.Team;
import za.ac.cput.util.Helper;

public class TeamFactory {
    public static Team build(String teamId, String teamName, String numberOfPlayers, String maxNumberOfPlayers) {
        Helper.checkStringParam("teamID", teamId);
        Helper.checkStringParam("teamName", teamName);
        Helper.checkStringParam("numberOfPlayers", numberOfPlayers);
        Helper.checkStringParam("maxNumberOfPlayers", maxNumberOfPlayers);

        return new Team.Builder().setTeamId(teamId)
                .setTeamName(teamName)
                .setNumberOfPlayers(numberOfPlayers)
                .setMaxNumberOfPlayers(maxNumberOfPlayers)
                .build();
    }
}
