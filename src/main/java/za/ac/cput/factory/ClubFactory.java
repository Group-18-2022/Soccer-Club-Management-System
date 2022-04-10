package za.ac.cput.factory;

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
