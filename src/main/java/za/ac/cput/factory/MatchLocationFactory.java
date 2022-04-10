package za.ac.cput.factory;

import za.ac.cput.entity.MatchLocation;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationFactory.java -> is a class that is used to link 'Location' and 'Match'.
 */

public class MatchLocationFactory {

    public static MatchLocation createMatchLocation(String locationID, String matchID) {
        if(isParametersNull(locationID, matchID) || isParametersEmpty(locationID, matchID))
            throw new IllegalStateException("Invalid values");

        var matchLocation = new MatchLocation.Builder()
                .setLocationId(locationID)
                .setMatchId(matchID)
                .build();

        return matchLocation;
    }

    private static boolean isParametersNull(String locationID, String matchID) {
        return Helper.isNull(locationID) || Helper.isNull(matchID);
    }

    private static boolean isParametersEmpty(String locationID, String matchID) {
        return Helper.isEmpty(locationID) || Helper.isEmpty(matchID);
    }
}
