package za.ac.cput.factory;
/**
 * This is the Club Factory
 * @author Charles Moses Lemmert (220498385)
 * 08 April 2022s
 * **/
import za.ac.cput.entity.Club;
import za.ac.cput.util.Helper;


public class ClubFactory {
    public static Club createClub(String clubName,String clubOwner,boolean isRegisteredClub){
        String clubID = Helper.generateID();
        return new Club.ClubBuilder()
                .setClubID(clubID)
                .setClubName(clubName)
                .setClubOwner(clubOwner)
                .setRegisteredClub(isRegisteredClub)
                .build();
    }
}
