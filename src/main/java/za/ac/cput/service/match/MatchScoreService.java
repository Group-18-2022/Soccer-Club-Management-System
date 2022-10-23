package za.ac.cput.service.match;

import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.service.IService;

import java.util.List;

public interface MatchScoreService extends IService<MatchScore, String> {
    void deleteById(String id);
    List<MatchScore> findAll();
}
