package za.ac.cput.factory.club;
/**
 * This is the Club Factory
 * @author Charles Moses Lemmert (220498385)
 * 08 April 2022s
 * **/
import za.ac.cput.domain.club.Club;
import za.ac.cput.util.Helper;


public class ClubFactory {
    public static Club createClub(String clubName,String clubOwner,boolean isRegisteredClub){

        if(Helper.isEmptyOrNull(clubName) || Helper.isEmptyOrNull(clubOwner)) return null;
        if(Helper.isEmptyOrNull(clubName) || Helper.isEmptyOrNull(clubOwner)) return null;

        String clubID = Helper.generateID();
        return new Club.ClubBuilder()
                .setClubID(clubID)
                .setClubName(clubName)
                .setClubOwner(clubOwner)
                .setRegisteredClub(isRegisteredClub)
                .build();
    }
}