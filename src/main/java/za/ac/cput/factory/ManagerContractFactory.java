package za.ac.cput.factory;

import za.ac.cput.entity.ManagerContract;
import za.ac.cput.util.Helper;

/*
 * @author Mponeng Ratego
 *216178991
 */

public class ManagerContractFactory {

    public static ManagerContract createManagerContract(int contractid, int milestonesOnTime, int numberOfGrievyances, Contract contract) {
        if(isValidParameters(kitType, kitColour)) throw new IllegalStateException("Invalid values");

        var managerContract = new ManagerContract.Builder()
                .setcontractid(contractid)
                .setmilestonesOnTime(milestonesOnTime)
                .setnumberOfGrievyances(numberOfGrievyances)
                .setcontract(contract)
                .build();

        return managerContract;
    }

    private static boolean isValidParameters(String kitType, String kitColour) {
        return (Helper.isNull(kitType) || Helper.isNull(kitColour) || Helper.isEmpty(kitType) || Helper.isEmpty(kitColour));
    }
}
