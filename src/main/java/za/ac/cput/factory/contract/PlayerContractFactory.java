package za.ac.cput.factory.contract;

import za.ac.cput.domain.contract.Contract;
import za.ac.cput.domain.contract.PlayerContract;
import za.ac.cput.util.Helper;

public class PlayerContractFactory {
    public static PlayerContract createPlayerContract(String contractId, int goalTarget, int matchesPlayed, Contract contract){

        if(Helper.isEmptyOrNull(contractId)) return null;

        return new PlayerContract.Builder()
                .setContractId(contractId)
                .setGoalTarget(goalTarget)
                .setMatchesPlayed(matchesPlayed)
                .setContract(contract)
                .build();
    }
}
