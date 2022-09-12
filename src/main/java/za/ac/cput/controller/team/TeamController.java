package za.ac.cput.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.team.Team;
import za.ac.cput.factory.team.TeamFactory;
import za.ac.cput.service.team.impl.TeamServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/soccer-management/team/")
public class TeamController {
    private final TeamServiceImpl teamService;

    @Autowired
    public TeamController(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

    @PostMapping("save")
    public ResponseEntity<Team> save(@Valid @RequestBody Team team) {
        Team newTeam = TeamFactory.build(team.getTeamId(), team.getTeamName(), team.getMaxNumberOfPlayers(), team.getNumberOfPlayers());
        Team teamSaved = this.teamService.save(newTeam);
        return ResponseEntity.ok(teamSaved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Team> read(@PathVariable String id) {
        Team readTeam= this.teamService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        return ResponseEntity.ok(readTeam);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Team team) {
        this.teamService.delete(team);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Team>> findAll() {
        List<Team> findAllTeamList = this.teamService.findAll();
        return ResponseEntity.ok(findAllTeamList);
    }

}
