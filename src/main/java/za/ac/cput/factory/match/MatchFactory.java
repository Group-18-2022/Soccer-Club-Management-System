package za.ac.cput.factory.match;

import za.ac.cput.domain.match.SoccerMatch;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * MatchFactory.java -> is a class that is used to create 'SoccerMatch'.
 */

public class MatchFactory {

    public static SoccerMatch createMatch(String matchID, String opponent, String kitType, String date, String time) {
        Helper.checkStringParam("matchID", matchID);
        Helper.checkStringParam("opponent", opponent);
        Helper.checkStringParam("kitType", kitType);
        Helper.checkStringParam("date", date);
        Helper.checkStringParam("time", time);

        return new SoccerMatch.Builder()
                .setMatchId(matchID)
                .setOpponent(opponent)
                .setKitType(kitType)
                .setDate(date)
                .setTime(time)
                .build();
    }
}
