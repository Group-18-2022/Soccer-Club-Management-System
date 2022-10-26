/*
Mponenge Ratego
216178991
Assignment 1
 */

package za.ac.cput.domain.contract;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ManagerContract {
    @NotNull
    @Id
    private String contractId;

    @NotNull
    private String milestonesOnTime;

    @NotNull
    private int numberOfGrievances;

    @Embedded
    @NotNull

    private Contract contract;

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    protected ManagerContract() {
    }

    private ManagerContract(Builder builder) {
        this.contractId = builder.contractId;
        this.milestonesOnTime = builder.milestonesOnTime;
        this.numberOfGrievances = builder.numberOfGrievances;
        this.contract = builder.contract;

    }

    public String getContractId() {
        return contractId;
    }

    public String getMilestonesOnTime() {
        return milestonesOnTime;
    }

    public int getNumberOfGrievances() {
        return numberOfGrievances;
    }

    public Contract getContract() {
        return contract;
    }


    @Override
    public String toString() {
        return "ManagerContract{" +
                "ContractId:" + contractId +
                ", MilestonesOnTime:'" + milestonesOnTime + '\'' +
                ", NumberOfGrievances:'" + numberOfGrievances + '\'' +
                ", Contract:" + contract +
                '}';
    }

    public static class Builder {
        private String contractId;
        private String milestonesOnTime;
        private int numberOfGrievances;
        private Contract contract;


        public Builder setContractId(String contractId) {
            this.contractId = contractId;
            return this;
        }

        public Builder setMilestonesOnTime(String milestonesOnTime) {
            this.milestonesOnTime = milestonesOnTime;
            return this;
        }

        public Builder setNumberOfGrievances(int numberOfGrievances) {
            this.numberOfGrievances = numberOfGrievances;
            return this;
        }

        public Builder setContract(Contract contract) {
            this.contract = contract;
            return this;
        }


        public Builder copy(ManagerContract managerContract) {
            this.contractId = managerContract.contractId;
            this.milestonesOnTime = managerContract.milestonesOnTime;
            this.numberOfGrievances = managerContract.numberOfGrievances;
            this.contract = managerContract.contract;


            return this;
        }

        public ManagerContract build() {
            return new ManagerContract(this);
        }

    }
}
