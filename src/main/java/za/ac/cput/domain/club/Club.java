package za.ac.cput.domain.club;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This is the Club entity
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
@Entity
public class Club {
    @NotNull @Id
    private String clubId;
    @NotNull
    private String clubName;
    @NotNull
    private String clubOwner;
    @NotNull
    private boolean isRegisteredClub;


    protected  Club(){}
    private Club(ClubBuilder builder){
        this.clubId = builder.clubID;
        this.clubName = builder.clubName;
        this.clubOwner = builder.clubOwner;
        this.isRegisteredClub = builder.isRegisteredClub;
    }
    public String getClubId() {
        return clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubOwner() {
        return clubOwner;
    }

    public boolean getIsRegisteredClub() {
        return isRegisteredClub;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubID:" + clubId +
                ", clubName:'" + clubName + '\'' +
                ", clubOwner:'" + clubOwner + '\'' +
                ", isRegisteredClub:" + isRegisteredClub +
                '}';
    }

    public static class ClubBuilder{
        private String clubID;
        private String clubName;
        private String clubOwner;
        private boolean isRegisteredClub;

        public ClubBuilder setClubID(String clubID) {
            this.clubID = clubID;
            return this;
        }

        public ClubBuilder setClubName(String clubName) {
            this.clubName = clubName;
            return this;
        }

        public ClubBuilder setClubOwner(String clubOwner) {
            this.clubOwner = clubOwner;
            return this;
        }

        public ClubBuilder setRegisteredClub(boolean registeredClub) {
            isRegisteredClub = registeredClub;
            return this;
        }

        public ClubBuilder copy(Club club){
            this.clubID = club.clubId;
            this.clubName = club.clubName;
            this.clubOwner = club.clubOwner;
            this.isRegisteredClub = club.isRegisteredClub;
            return this;
        }

        public Club build(){
            return new Club(this);
        }
    }


}
