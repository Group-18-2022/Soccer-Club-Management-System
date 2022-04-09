package za.ac.cput.factory;

import za.ac.cput.entity.Kit;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * KitFactory.java -> is a class that is used to create 'Kit(s)' for each team.
 */

public class KitFactory {

    public static Kit createKit(String kitType, String kitColour, String kitBrand) {
        if(isValidParameters(kitType, kitColour)) throw new IllegalStateException("Invalid values");

        var kit = new Kit.Builder()
                .setKitType(kitType)
                .setKitColor(kitColour)
                .setKitBrand(kitBrand)
                .build();

        return kit;
    }

    private static boolean isValidParameters(String kitType, String kitColour) {
        return (Helper.isNull(kitType) || Helper.isNull(kitColour) || Helper.isEmpty(kitType) || Helper.isEmpty(kitColour));
    }
}
