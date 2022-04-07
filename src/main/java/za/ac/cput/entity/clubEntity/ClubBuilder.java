package za.ac.cput.entity.clubEntity;

/**
 * This is the ClubBuilder
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public class ClubBuilder {

    String clubID;
    String clubName;
    String clubOwner;
    boolean isRegisteredClub;

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
    public Club build(){
        return new Club(this);
    }
}
