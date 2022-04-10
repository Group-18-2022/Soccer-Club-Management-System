package za.ac.cput.entity;

/*
 * @author Mponeng Ratego
 * 216178991
 */
import java.entity.Contract;

public class ManagerContract {
    private int contractid;
    private int milestonesOnTime;
    private int numberOfGrievyances;
    private Contract contract;

    private ManagerContract(Builder builder) {
        this.contractid = builder.contractid;
        this.milestonesOnTime = builder.milestonesOnTime;
        this.numberOfGrievyances = builder.numberOfGrievyances;
        this.contract = builder.contract;
    }

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractidate) {
        this.contractid = contractid;
    }


    public int getMilestonesOnTime() {
        return goalmilestonesOnTimeTarget;
    }

    public void setMilestonesOnTime(int milestonesOnTime) {
        this.milestonesOnTime = milestonesOnTime;
    }


    public int getMatchesPlayed() {
        return numberOfGrievyances;
    }

    public void setNumberOfGrievyances(int MatchesPlayed) {
       this.numberOfGrievyances = numberOfGrievyances
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "ManagerContract{" +
                "contractid=" + contractid +
                ", milestonesOnTime=" + milestonesOnTime +
                ", numberOfGrievyances=" + numberOfGrievyances +
                ", contract=" + contract +
                '}';
    }

    public static class Builder {

        private int contractid;
        private int milestonesOnTime;
        private int numberOfGrievyances;
        private Contract contract;


        public Builder setContractid(int contractid) {
            this.contractid = contractid;
            return this;
        }

        public Builder setMilestonesOnTime(int milestonesOnTime) {
            this.milestonesOnTime = milestonesOnTime;
            return this;
        }

        public Builder setNumberOfGrievyances(int numberOfGrievyances) {
            this.numberOfGrievyances = numberOfGrievyances;
            return this;
        }

        public Builder setContract(Contract contract) {
            this.contract = contract;
            return this;
        }


        public Builder copy(ManagerContract managerContractact) {

            private int contractid;
            private int milestonesOnTime;
            private int numberOfGrievyances;
            private Contract contract;

            return this;
        }

        public ManagerContract build() {
            return new ManagerContract(this);
        }


    }

}