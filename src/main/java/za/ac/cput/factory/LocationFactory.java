package za.ac.cput.factory;

import za.ac.cput.entity.Location;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * LocationFactory.java -> is a class that is used to create Locations for the problem domain.
 */

public class LocationFactory {

    public static Location createLocation(String stadiumName) {
        String locationID = Helper.generateID();
        var location = new Location.Builder()
                .setLocationId(locationID)
                .setStadiumName(stadiumName)
                .build();

        return location;
    }
}
