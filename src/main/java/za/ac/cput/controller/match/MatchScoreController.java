package za.ac.cput.controller.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.match.MatchScoreAPI;
import za.ac.cput.domain.match.MatchScore;
import za.ac.cput.factory.match.MatchScoreFactory;
import za.ac.cput.service.match.impl.MatchScoreServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/matchScore/")
public class MatchScoreController {
    private final MatchScoreServiceImpl matchScoreService;
    private final MatchScoreAPI api;

    @Autowired
    public MatchScoreController(MatchScoreServiceImpl service, MatchScoreAPI api) {
        this.matchScoreService = service;
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<MatchScore> save(@Valid @RequestBody MatchScore matchScore) {
        MatchScore saveScore = MatchScoreFactory.createMatchScore(matchScore.getMatchId(), matchScore.getOpponentScore(), matchScore.getTeamScore());
        return ResponseEntity.ok(api.save(saveScore));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<MatchScore> read(@PathVariable String id) {
        var score = this.matchScoreService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoccerMatch Score Not Found"));
        return ResponseEntity.ok(score);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(MatchScore matchScore) {
        this.matchScoreService.delete(matchScore);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        this.matchScoreService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<MatchScore>> findAll() {
        List<MatchScore> scores = this.matchScoreService.findAll();
        return ResponseEntity.ok(scores);
    }
}
