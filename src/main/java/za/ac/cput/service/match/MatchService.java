package za.ac.cput.service.match;

import za.ac.cput.domain.match.SoccerMatch;
import za.ac.cput.service.IService;

import java.util.List;

public interface MatchService extends IService<SoccerMatch, String> {
    void deleteById(String id);
    List<SoccerMatch> findAll();
}
