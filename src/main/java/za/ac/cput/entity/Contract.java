package za.ac.cput.entity;

/*
 * @author Mponeng Ratego
 * 216178991
 */
import java.entity.PersonalDetails;
import java.time.LocalDate;

public class Contract {

    private LocalDate signedDate;
    private LocalDate expDate;
    private String signedLocation;
    private PersonalDetails personalDetails;
    private int duration;

    private Contract(Builder builder){
        this.signedDate = builder.signedDate;
        this.expDate = builder.expDate;
        this.signedLocation = builder.signedLocation;
        this.personalDetails = builder.personalDetails;
        this.duration = builder.duration;
    }

    public LocalDate getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(LocalDate signedDate) {
        this.signedDate = signedDate;
    }



    public String getSignedLocation() {
        return signedLocation;
    }

    public void setSignedLocation(String signedLocation) {
        this.signedLocation = signedLocation;
    }



    public witness getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }



    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Contract{" +
                "signedDate=" + signedDate +
                ", expDate=" + expDate +
                ", signedLocation=" + signedLocation +
                ", personalDetails=" + personalDetails +
                ", duration=" + duration +
                '}';
    }


    public static class Builder {

        private LocalDate signedDate;
        private LocalDate expDate;
        private String signedLocation;
        private witness personalDetails;
        private int duration;



        public Builder setSignedDate(LocalDate signedDate) {
            this.signedDate = signedDate;
            return this;
        }

        public Builder setExpDate(LocalDate expDate) {
            this.expDate = expDate;
            return this;
        }

        public Builder setSignedLocation(String signedLocation) {
            this.signedLocation = signedLocation;
            return this;
        }

        public Builder setPersonalDetails(PersonalDetails personalDetails) {
            this.personalDetails = personalDetails;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder copy(Contract contract){

            this.signedDate = contract.signedDate;
            this.expDate = contract.expDate;
            this.signedLocation = contract.signedLocation;
            this.personalDetails = contract.personalDetails;
            this.duration = contract.duration

            return this;
        }

        public Contract build(){
            return new Contract(this);
        }



    }
}