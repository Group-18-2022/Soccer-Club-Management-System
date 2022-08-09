/*
Mponenge Ratego
216178991
Assignment 1
 */

package za.ac.cput.factory.contract;


import za.ac.cput.domain.contract.Contract;
import za.ac.cput.domain.contract.ManagerContract;
import za.ac.cput.util.Helper;

public class ManagerContractFactory {
    public static ManagerContract createManagerContract(String contractId, String milestonesOnTime, int numberOfGrievances, Contract contract){

        if(Helper.isEmptyOrNull(contractId)||Helper.isEmptyOrNull(milestonesOnTime)) return null;

        return new ManagerContract.Builder()
                .setContractId(contractId)
                .setMilestonesOnTime(milestonesOnTime)
                .setNumberOfGrievances(numberOfGrievances)
                .setContract(contract)
                .build();
    }
}
