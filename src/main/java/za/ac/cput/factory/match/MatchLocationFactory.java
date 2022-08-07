package za.ac.cput.factory.match;

import za.ac.cput.domain.lookup.MatchLocation;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationFactory.java -> is a class that is used to link 'Location' and 'SoccerMatch'.
 */

public class MatchLocationFactory {

    public static MatchLocation createMatchLocation(String locationID, String matchID) {
        Helper.checkStringParam("locationID", locationID);
        Helper.checkStringParam("matchID", matchID);

        return new MatchLocation.Builder()
                .setLocationId(locationID)
                .setMatchId(matchID)
                .build();
    }
}
