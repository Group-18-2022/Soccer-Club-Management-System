package za.ac.cput.factory;

import za.ac.cput.entity.MatchScore;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreFactory.java -> is a class that is used to create the score for each match played.
 */
public class MatchScoreFactory {

    public static MatchScore createMatchScore(String matchID, byte opponentScore, byte teamScore) {
        var matchScore = new MatchScore.Builder()
                .setMatchID(matchID)
                .setOpponentScore(opponentScore)
                .setTeamScore(teamScore)
                .build();

        return matchScore;
    }
}
