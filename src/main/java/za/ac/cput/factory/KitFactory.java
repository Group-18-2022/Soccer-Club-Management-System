package za.ac.cput.factory;

import za.ac.cput.entity.Kit;

/*
 * @author Karl Haupt (220236585)
 * KitFactory.java -> is a class that is used to create 'Kit(s)' for each team.
 */

public class KitFactory {

    public static Kit createKit(String kitType, String kitColour, String kitBrand) {
        var kit = new Kit.Builder()
                .setKitType(kitType)
                .setKitColor(kitColour)
                .setKitBrand(kitBrand)
                .build();

        return kit;
    }
}
