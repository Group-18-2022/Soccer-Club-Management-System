package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchScoreRepository.java -> is a class that performs CRUD operations on the MatchScore domain.
 */

import za.ac.cput.entity.MatchScore;

import java.util.HashSet;
import java.util.Set;

public class MatchScoreRepository implements IRepositoryMatchScore {
    private static MatchScoreRepository repository = null;
    private Set<MatchScore> matchScoreDB;

    private MatchScoreRepository() {
        this.matchScoreDB = new HashSet<>();
    }

    public static MatchScoreRepository getRepository() {
        if(repository == null) repository = new MatchScoreRepository();
        return repository;
    }

    @Override
    public MatchScore create(MatchScore matchScore) {
        boolean isSuccessful = matchScoreDB.add(matchScore);
        if(!isSuccessful) return null;
        return matchScore;
    }

    @Override
    public MatchScore read(String matchID) {
        var matchScore = matchScoreDB.stream()
                .filter(m -> m.getMatchID().equals(matchID))
                .findAny().orElse(null);
        return matchScore;
    }

    @Override
    public MatchScore update(MatchScore matchScore) {
        var currentMatchScore = read(matchScore.getMatchID());
        if(matchScore != null) {
            matchScoreDB.remove(currentMatchScore);
            matchScoreDB.add(matchScore);
            return matchScore;
        }
        return null;
    }

    @Override
    public boolean delete(String matchID) {
        boolean isSuccessful = true;
        var matchScoreToDelete = read(matchID);
        System.out.println(matchID);
        if(matchScoreToDelete != null) isSuccessful = matchScoreDB.remove(matchScoreToDelete);
        return isSuccessful;
    }

    @Override
    public Set<MatchScore> getAllMatchScore() {
        return matchScoreDB;
    }

    @Override
    public boolean contains(String matchID) {
        var matchScore = read(matchID);
        if(matchScore != null) return true;
        return false;
    }
}
