package za.ac.cput.factory;

/* SponsorFactory.java
   Factory for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import za.ac.cput.domain.Sponsor;
import za.ac.cput.util.Helper;

public class SponsorFactory {

    public static Sponsor createSponsor(String roleID, String taxNumber, String companyName) {
        Helper.checkStringParam("roleID", roleID);
        Helper.checkStringParam("taxNumber", taxNumber);
        Helper.checkStringParam("companyName", companyName);

        return new Sponsor.Builder()
                .setRoleID(roleID)
                .setTaxNumber(taxNumber)
                .setCompanyName(companyName)
                .build();
    }
}
