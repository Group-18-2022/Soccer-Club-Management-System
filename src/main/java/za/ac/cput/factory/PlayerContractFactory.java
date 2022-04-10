package za.ac.cput.factory;

import za.ac.cput.entity.PlayerContract;
import za.ac.cput.util.Helper;

/*
 * @author Mponeng Ratego
 * 216178991
 */

public class PlayerContract {

    public static PlayerContract createPlayerContract(int contractid, int goalTarget, int matchesPlayed, Contract contract) {
        if(isValidParameters(signedDate, expDate)) throw new IllegalStateException("Sign contract first");

        var playerContract = new PlayerContract.Builder()
                .setcontractid(contractid)
                .setgoalTarget(goalTarget)
                .setmatchesPlayed(matchesPlayed)
                .setcontract(contract)
                .build();

        return playerContract;
    }


}