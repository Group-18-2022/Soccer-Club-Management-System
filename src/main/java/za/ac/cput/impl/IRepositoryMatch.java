package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * IRepositoryMatch.java -> is an interface that is used by MatchRepository.
 */

import za.ac.cput.entity.Match;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRepositoryMatch extends IRepository<Match, String> {
    Set<Match> getAllMatch();
    boolean contains(String matchID);
}
