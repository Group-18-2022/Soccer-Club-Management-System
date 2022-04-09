package za.ac.cput.factory;

import za.ac.cput.entity.MatchScore;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreFactory.java -> is a class that is used to create the score for each match played.
 */
public class MatchScoreFactory {

    public static MatchScore createMatchScore(String matchID, byte opponentScore, byte teamScore) {
        if(Helper.isNull(matchID) || Helper.isEmpty(matchID) ||
           !isPositive(opponentScore) || !isPositive(teamScore)) throw  new IllegalStateException("Invalid values");

        var matchScore = new MatchScore.Builder()
                .setMatchID(matchID)
                .setOpponentScore(opponentScore)
                .setTeamScore(teamScore)
                .build();

        return matchScore;
    }

    private static boolean isPositive(byte number) {
        return (number >= 0);
    }
}
