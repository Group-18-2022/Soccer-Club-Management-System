package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * MatchRepository.java -> is a class that performs CRUD operations on the Match domain.
 */

import za.ac.cput.entity.Match;

import java.util.HashSet;
import java.util.Set;

public class MatchRepository implements IRepositoryMatch {
    private static MatchRepository repository = null;
    private HashSet<Match> matchDB;

    private MatchRepository() {
        this.matchDB = new HashSet<>();
    }

    public static MatchRepository getRepository() {
        if(repository == null) repository = new MatchRepository();
        return repository;
    }

    @Override
    public Match create(Match match) {
        boolean isSuccessful = matchDB.add(match);
        if(!isSuccessful) return null;
        return match;
    }

    @Override
    public Match read(String matchID) {
        var match = matchDB.stream()
                .filter(m -> m.getMatchId().equals(matchID))
                        .findAny().orElse(null);
        return match;
    }

    @Override
    public Match update(Match match) {
        var currentMatch = read(match.getMatchId());
        if(currentMatch != null) {
            matchDB.remove(currentMatch);
            matchDB.add(match);
            return match;
        }
        return null;
    }

    @Override
    public boolean delete(String matchID) {
        boolean isSuccessful = true;
        var matchToDelete = read(matchID);
        if(matchToDelete != null) isSuccessful = matchDB.remove(matchToDelete);
        return isSuccessful;
    }

    @Override
    public Set<Match> getAllMatch() {
        return matchDB;
    }

    @Override
    public boolean contains(String matchID) {
        var match = read(matchID);
        if(match != null) return true;
        return false;
    }
}
