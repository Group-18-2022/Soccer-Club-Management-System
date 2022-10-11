package za.ac.cput.api.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.service.match.impl.MatchScoreServiceImpl;
import za.ac.cput.service.match.impl.MatchServiceImpl;

@Component
public class MatchScoreAPI {
    private final MatchServiceImpl matchService;
    private final MatchScoreServiceImpl matchScoreService;

    @Autowired
    public MatchScoreAPI(MatchServiceImpl matchService, MatchScoreServiceImpl matchScoreService) {
        this.matchService = matchService;
        this.matchScoreService = matchScoreService;
    }

    public MatchScore save(MatchScore matchScore) {
        this.matchService.read(matchScore.getMatchId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return this.matchScoreService.save(matchScore);
    }
}
