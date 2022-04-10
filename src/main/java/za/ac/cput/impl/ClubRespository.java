package za.ac.cput.impl;
/**
 * This is the Club Repository
 * @author Charles Moses Lemmert (220498385)
 * 09 April 2022
 * **/


import za.ac.cput.entity.Club;

import java.util.HashSet;
import java.util.Set;

public class ClubRespository implements  IClubRepository{
    private static ClubRespository clubRespository = null;
    private Set<Club> clubDB = null;

    private ClubRespository(){
        clubDB = new HashSet<>();
    }

    public static ClubRespository getClubRespository(){
        if(clubRespository == null) clubRespository = new ClubRespository();
        return clubRespository;
    }
    @Override
    public Club create(Club club) {
        boolean createClub = clubDB.add(club);
        if(!createClub)return null;
        return club;
    }

    @Override
    public Club read(String clubID) {

        for(Club club: clubDB)
            if(club.getClubID().equals(clubID))
                return club;

        return null;
    }

    @Override
    public Club update(Club club) {
        Club updateClub = read(club.getClubID());
        if(updateClub != null){
            clubDB.remove(updateClub);
            clubDB.add(updateClub);
            return club;
        }
        return null;
    }

    @Override
    public boolean delete(String clubID) {
        Club deleteClub = read(clubID);
        if(deleteClub != null){
            clubDB.remove(deleteClub);
            return true;
        }
        return false;
    }

    @Override
    public Set<Club> getAll() {
        return clubDB;
    }
}
