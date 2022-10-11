package za.ac.cput.factory.match;

import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreFactory.java -> is a class that is used to create the score for each match played.
 */
public class MatchScoreFactory {

    public static MatchScore createMatchScore(String matchID, byte opponentScore, byte teamScore) {
        Helper.checkStringParam("matchID", matchID);
        if(!isPositive(opponentScore) || !isPositive(teamScore)) throw  new IllegalArgumentException("Score(s) must be positive");

        return new MatchScore.Builder()
                .setMatchId(matchID)
                .setOpponentScore(opponentScore)
                .setTeamScore(teamScore)
                .build();

    }

    private static boolean isPositive(byte number) {
        return (number >= 0);
    }
}
