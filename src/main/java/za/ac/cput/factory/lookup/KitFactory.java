package za.ac.cput.factory.lookup;

import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.util.Helper;

/*
 * @author Karl Haupt (220236585)
 * KitFactory.java -> is a class that is used to create 'Kit(s)' for each team.
 */

public class KitFactory {

    public static Kit createKit(String kitType, String kitColour, String kitBrand) {
        Helper.checkStringParam("kitType", kitType);
        Helper.checkStringParam("kitColour", kitColour);
        Helper.checkStringParam("kitBrand", kitBrand);

        return new Kit.Builder()
                .setKitType(kitType)
                .setKitColor(kitColour)
                .setKitBrand(kitBrand)
                .build();
    }

}
