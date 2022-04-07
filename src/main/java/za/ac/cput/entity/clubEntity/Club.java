package za.ac.cput.entity.clubEntity;

/**
 * This is the Club entity
 * @author Charles Moses Lemmert (220498385)
 * 05 April 2022
 * **/
public class Club {

//    ContactInfoManager builder;
    private String clubID;
    private String clubName;
    private String clubOwner;
    private boolean isRegisteredClub;
    ClubBuilder builder;

    Club(ClubBuilder builder) {
        this.clubID = builder.clubID;
        this.clubName = builder.clubName;
        this.clubOwner = builder.clubOwner;
        this.isRegisteredClub = builder.isRegisteredClub;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubID:'" + clubID + '\'' +
                ", clubName:'" + clubName + '\'' +
                ", clubOwner:'" + clubOwner + '\'' +
                ", isRegisteredClub:" + isRegisteredClub +
                '}';
    }
}
