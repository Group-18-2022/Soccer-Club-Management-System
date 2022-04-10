package za.ac.cput.factory;

import za.ac.cput.entity.Contract;
import za.ac.cput.util.Helper;

/*
 * @author Mponeng Ratego
 * 216178991
 */

public class ContractFactory {

    public static Contract createContract(LocalDate signedDate, LocalDate expDate, locationId signedLocation, witness personalDetails, int duration) {
        if(isValidParameters(signedDate, expDate)) throw new IllegalStateException("Sign contract first");

        var contract = new Contract.Builder()
                .setsignedDate(signedDate)
                .setexpDate(expDate)
                .setsignedLocation(signedLocation)
                .setpersonalDetails(personalDetails)
                .setduration(duration)
                .build();

        return contract;
    }

    private static boolean isValidParameters(localDate signedDate, LocalDate expDate) {
        return (Helper.isNull(signedDate) || Helper.isNull(expDate) || Helper.isEmpty(signedDate) || Helper.isEmpty(expDate));
    }
}