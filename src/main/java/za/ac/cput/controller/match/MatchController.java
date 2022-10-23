package za.ac.cput.controller.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.match.SoccerMatch;
import za.ac.cput.factory.match.MatchFactory;
import za.ac.cput.service.match.impl.MatchServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/match/")
public class MatchController {
    private final MatchServiceImpl matchService;

    @Autowired
    public MatchController(MatchServiceImpl service) {
        this.matchService = service;
    }

    @PostMapping("save")
    public ResponseEntity<SoccerMatch> save(@Valid @RequestBody SoccerMatch soccerMatch) {
        SoccerMatch saveSoccerMatch = MatchFactory.createMatch(soccerMatch.getMatchId(), soccerMatch.getOpponent(), soccerMatch.getKitType(), soccerMatch.getDate(), soccerMatch.getTime());
        return ResponseEntity.ok(matchService.save(saveSoccerMatch));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<SoccerMatch> read(@PathVariable String id) {
        var match = this.matchService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoccerMatch Not Found"));
        return  ResponseEntity.ok(match);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(SoccerMatch soccerMatch) {
        this.matchService.delete(soccerMatch);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        this.matchService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<SoccerMatch>> findAll() {
        List<SoccerMatch> soccerMatches = this.matchService.findAll();
        return ResponseEntity.ok(soccerMatches);
    }
}
