/*
Mponenge Ratego
216178991
Assignment 1
 */

package za.ac.cput.domain.contract;

import za.ac.cput.domain.lookup.PersonalDetails;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Embeddable
public class Contract {
    @NotNull
    private String signedDate;

    @NotNull
    private String expDate;

    @NotNull
    private String signedLocation;

    @NotNull
    private PersonalDetails witness;

    @NotNull
    private String duration;


    protected Contract() {
    }

    private Contract(Builder builder) {
        this.signedDate = builder.signedDate;
        this.expDate = builder.expDate;
        this.signedLocation = builder.signedLocation;
        this.witness = builder.witness;
        this.duration = builder.duration;

    }

    public String getSignedDate() {
        return signedDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getSignedLocation() {
        return signedLocation;
    }

    public PersonalDetails getWitness() {
        return witness;
    }

    public String getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return "Contract{" +
                "SignedDate:" + signedDate +
                ", ExpDate:'" + expDate + '\'' +
                ", SignedLocation:'" + signedLocation + '\'' +
                ", Witness:'" + witness + '\'' +
                ", Duration:" + duration +
                '}';
    }

    public static class Builder {

        private String signedDate;

        private String expDate;

        private String signedLocation;

        private PersonalDetails witness;

        private String duration;


        public Builder setSignedDate(String signedDate) {
            this.signedDate = signedDate;
            return this;
        }

        public Builder setExpDate(String expDate) {
            this.expDate = expDate;
            return this;
        }

        public Builder setSignedLocation(String signedLocation) {
            this.signedLocation = signedLocation;
            return this;
        }

        public Builder setWitness(PersonalDetails witness) {
            this.witness = witness;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }


        public Builder copy(Contract contract) {
            this.signedDate = contract.signedDate;
            this.expDate = contract.expDate;
            this.signedLocation = contract.signedLocation;
            this.witness = contract.witness;
            this.duration = contract.duration;


            return this;
        }

        public Contract build() {
            return new Contract(this);
        }

    }
}