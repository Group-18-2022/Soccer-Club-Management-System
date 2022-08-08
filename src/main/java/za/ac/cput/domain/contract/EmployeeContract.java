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
public class EmployeeContract
{
    @NotNull
    @Id
    private Contract contractId;

    @NotNull
    private String personId;

    protected Contract()
    {
    }

    private EmployeeContract (Builder builder) {
        this.contractId = builder.contractId;
        this.personId = builder.personId;
    }

    public Contract getContractId(){
        return contractId;
    }

    public String getPersonId(){
        return personId;
    }

    @Override
    public String toString() {
        return "EmployeeContract{" +
                "ContractId='" + contractId + '\'' +
                ", PersonId='" + personId
                + '\'' +
                '}';
    }

    public static class Builder {
        private Contract contractId;
        private String personId;

        public Builder setContractId(Contract contractId){
            this.contractId = contractId;
            return this;
        }

        public Builder setPersonId(String personId){
            this.personId = personId;
            return this;
        }

        public Builder copy(EmployeeContract employeeContract) {
            this.contractId = employeeContract.contractId;
            this.personId = employeeContract.personId;

            return this;
        }

        public EmployeeContract build() {
            return new EmployeeContract(this);
        }

}
