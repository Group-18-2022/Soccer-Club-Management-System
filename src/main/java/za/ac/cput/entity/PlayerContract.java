package za.ac.cput.entity;

/*
 * @author Mponeng Ratego
 * 216178991
 */

public class PlayerContract {

    private int contractid;
    private int goalTarget;
    private int matchesPlayed;
    private Contract contract;

    private PlayerContract(Builder builder) {
        this.contractid = builder.contractid;
        this.goalTarget = builder.goalTarget;
        this.matchesPlayed = builder.matchesPlayed;
        this.contract = builder.contract;
    }

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractidate) {
        this.contractid = contractid;
    }


    public int getGoalTarget() {
        return goalTarget;
    }

    public void setGoalTarget(int goalTarget) {
        this.goalTarget = goalTarget;
    }


    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int MatchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "PlayerContract{" +
                "contractid=" + contractid +
                ", goalTarget=" + goalTarget +
                ", matchesPlayed=" + matchesPlayed +
                ", contract=" + contract +
                '}';
    }

    public static class Builder {

        private int contractid;
        private int goalTarget;
        private int matchesPlayed;
        private Contract contract;


        public Builder setContractid(int contractid) {
            this.contractid = contractid;
            return this;
        }

        public Builder setGoalTarget(int goalTarget) {
            this.goalTarget = goalTarget;
            return this;
        }

        public Builder setMatchesPlayed(int matchesPlayed) {
            this.matchesPlayed = matchesPlayed;
            return this;
        }

        public Builder setContract(Contract contract) {
            this.contract = contract;
            return this;
        }


        public Builder copy(PlayerContract playerContract) {

            this.contractid = playerContract.contractid;
            this.goalTarget = playerContract.goalTarget;
            this.matchesPlayed = playerContract.matchesPlayed;
            this.contract = playerContract.contract;


            return this;
        }

        public PlayerContract build() {
            return new PlayerContract(this);
        }


    }
}