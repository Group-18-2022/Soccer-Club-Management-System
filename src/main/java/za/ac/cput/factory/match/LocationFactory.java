package za.ac.cput.factory.match;

import za.ac.cput.domain.match.Location;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * LocationFactory.java -> is a class that is used to create Locations for the problem domain.
 */

public class LocationFactory {

    public static Location createLocation(String locationID, String stadiumName) {
        Helper.checkStringParam("locationID", locationID);
        Helper.checkStringParam("stadiumName", stadiumName);

        return new Location.Builder()
                .setLocationId(locationID)
                .setStadiumName(stadiumName)
                .build();
    }
}
