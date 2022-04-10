package za.ac.cput.impl;

/* SponsorRepository.java
   Repository for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 09/04/2022
 */

import za.ac.cput.entity.Sponsor;

import java.util.HashSet;
import java.util.Set;

public class SponsorRepository implements ISponsorRepository{

    private static SponsorRepository repository = null;
    private Set<Sponsor> sponsorDB = null;

    private  SponsorRepository () {
        sponsorDB = new HashSet<Sponsor>();
    }

    public static SponsorRepository getRepository() {
        if (repository == null){
            repository = new SponsorRepository();
        }
        return repository;
    }

    @Override
    public Sponsor create(Sponsor sponsor) {
        boolean success = sponsorDB.add(sponsor);
        if(!success)
            return null;
        return sponsor;
    }

    @Override
    public Sponsor read(String roleID) {
        Sponsor sponsor = sponsorDB.stream()
                .filter(e -> e.getRoleID().equals(roleID))
                .findAny()
                .orElse(null);
        return sponsor;
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        Sponsor oldSponsor = read(sponsor.getRoleID());
        if (oldSponsor !=null){
            sponsorDB.remove(oldSponsor);
            sponsorDB.add(sponsor);
            return sponsor;
        }
        return null;
    }

    @Override
    public boolean delete(String roleID) {
        Sponsor sponsorToDelete = read(roleID);
        if (sponsorToDelete == null)
            return false;
        sponsorDB.remove(sponsorToDelete);
        return true;
    }

    @Override
    public Set<Sponsor> getAll() {
        return sponsorDB;
    }
}
