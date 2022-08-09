/*
Mponenge Ratego
216178991
Assignment 1
 */

package za.ac.cput.factory.contract;

import za.ac.cput.domain.contract.Contract;
import za.ac.cput.domain.lookup.PersonalDetails;
import za.ac.cput.util.Helper;

public class ContractFactory {
    public static Contract createContract(String signedDate, String expDate, String signedLocation,String duration, PersonalDetails witness)
    {

        if(Helper.isEmptyOrNull(signedDate)||Helper.isEmptyOrNull(expDate) || Helper.isEmptyOrNull(signedLocation) || Helper.isEmptyOrNull(duration))return null;

        return new Contract.Builder()
                .setSignedDate(signedDate)
                .setExpDate(expDate)
                .setSignedLocation( signedLocation)
                .setWitness( witness)
                .setDuration(duration)
                .build();
    }

}
