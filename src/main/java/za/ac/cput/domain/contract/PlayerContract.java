/*
Mponenge Ratego
216178991
Assignment 1
 */

package za.ac.cput.domain.contract;

import za.ac.cput.domain.contract.Contract;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PlayerContract
{
    @NotNull
    @Id
    private String contractId;

    @NotNull
    private int goalTarget;

    @NotNull
    private int matchesPlayed;

    @NotNull
    private Contract contract;

    protected PlayerContract()
    {
    }

    private PlayerContract (Builder builder) {
        this.contractId = builder.contractId;
        this.goalTarget = builder.goalTarget;
        this.matchesPlayed = builder.matchesPlayed;
        this.contract = builder.contract;

    }

    public String getContractId(){
        return contractId;
    }

    public int getGoalTarget(){
        return goalTarget;
    }

    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    public Contract getContract(){
        return contract;
    }



    @Override
    public String toString() {
        return "PlayerContract{" +
                "ContractId='" + contractId '\'' +
                ", GoalTarget='" + goalTarget '\'' +
                ", MatchesPlayed='" + matchesPlayed'\'' +
                ", Contract='" + contract'\''
                + '\'' +
                '}';
    }

    public static class Builder {
        private String contractId;
        private int goalTarget;
        private int matchesPlayed;
        private Contract contract;



        public Builder setContractId(String contractId){
            this.contractId = contractId;
            return this;
        }

        public Builder setGoalTarget(int goalTarget){
            this.goalTarget = goalTarget;
            return this;
        }

        public Builder setMatchesPlayed(int matchesPlayed){
            this.matchesPlayed = matchesPlayed;
            return this;
        }

        public Builder setContract(Contract contract){
            this.contract = contract;
            return this;
        }



        public Builder copy(PlayerContract playerContract) {
            this.contractId = playerContract.contractId;
            this.goalTarget = playerContract.goalTarget;
            this.matchesPlayed = playerContract.matchesPlayed;
            this.contract = playerContract.contract;



            return this;
        }

        public PlayerContract build() {
            return new PlayerContract(this);
        }

    }
