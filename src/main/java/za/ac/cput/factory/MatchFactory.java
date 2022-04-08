package za.ac.cput.factory;

import za.ac.cput.entity.Match;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * MatchFactory.java -> is a class that is used to create 'Match'.
 */

public class MatchFactory {

    public static Match createMatch(String opponent, String kitType, String date, String time) {
        String matchID = Helper.generateID();
        var match = new Match.Builder()
                .setMatchId(matchID)
                .setOpponent(opponent)
                .setKitType(kitType)
                .setDate(date)
                .setTime(time)
                .build();

        return match;
    }
}
