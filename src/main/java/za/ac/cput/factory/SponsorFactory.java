package za.ac.cput.factory;

/* SponsorFactory.java
   Factory for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 08/04/2022
 */

import za.ac.cput.entity.Sponsor;
import za.ac.cput.util.Helper;

public class SponsorFactory {

    public static Sponsor createSponsor(String taxNumber, String companyName) {
        if(Helper.isNull(taxNumber) || Helper.isNull(companyName) ||
            Helper.isEmpty(taxNumber) || Helper.isEmpty(companyName))
            throw new IllegalStateException("Invalid values");

        String roleID = Helper.generateID();
        var sponsor = new Sponsor.Builder()
                .setRoleID(roleID)
                .setTaxNumber(taxNumber)
                .setCompanyName(companyName)
                .build();

        return sponsor;
    }
}
