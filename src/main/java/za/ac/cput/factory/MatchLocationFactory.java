package za.ac.cput.factory;

import za.ac.cput.entity.MatchLocation;

/*
 * @author Karl Haupt (220236585)
 * MatchLocationFactory.java -> is a class that is used to link 'Location' and 'Match'.
 */

public class MatchLocationFactory {

    public static MatchLocation createMatchLocation(String locationID, String matchID) {
        var matchLocation = new MatchLocation.Builder()
                .setLocationId(locationID)
                .setMatchId(matchID)
                .build();

        return matchLocation;
    }
}
