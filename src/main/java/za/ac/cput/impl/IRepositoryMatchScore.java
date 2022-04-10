package za.ac.cput.impl;

/*
 * @author Karl Haupt (220236585)
 * IRepositoryMatchScore.java -> is an interface that is used by MatchScoreRepository.
 */

import za.ac.cput.entity.MatchScore;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRepositoryMatchScore extends IRepository<MatchScore, String> {
    Set<MatchScore> getAllMatchScore();
    boolean contains(String matchID);
}
