package za.ac.cput.controller.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.match.MatchLocationAPI;
import za.ac.cput.domain.lookup.MatchLocation;
import za.ac.cput.service.match.impl.MatchLocationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/soccer-management/matchLocation/")
public class MatchLocationController {
    private final MatchLocationServiceImpl matchLocationService;
    private MatchLocationAPI api;

    @Autowired
    public MatchLocationController(MatchLocationServiceImpl service, MatchLocationAPI api) {
        this.matchLocationService = service;
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<MatchLocation> save(@Valid @RequestBody MatchLocation matchLocation) {
        MatchLocation location = this.api.save(matchLocation);
        return ResponseEntity.ok(matchLocationService.save(location));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<MatchLocation> read(@PathVariable MatchLocation.MatchLocationID id) {
        var matchLocation = this.matchLocationService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoccerMatch Location Not Found"));
        return ResponseEntity.ok(matchLocation);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(MatchLocation matchLocation) {
        this.matchLocationService.delete(matchLocation);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<MatchLocation>> findAll() {
        List<MatchLocation> scores = this.matchLocationService.findAll();
        System.out.println("Length: " + scores.size());
        return ResponseEntity.ok(scores);
    }
}
