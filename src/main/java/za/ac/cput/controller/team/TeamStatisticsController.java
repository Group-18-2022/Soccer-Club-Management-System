package za.ac.cput.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.team.TeamStatistics;
import za.ac.cput.factory.team.TeamStatisticsFactory;
import za.ac.cput.service.team.impl.TeamStatisticsServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/soccer-management/team-statistics/")
public class TeamStatisticsController {
    private final TeamStatisticsServiceImpl teamStatisticsService;

    @Autowired
    public TeamStatisticsController(TeamStatisticsServiceImpl teamStatisticsService) {
        this.teamStatisticsService = teamStatisticsService;
    }

    @PostMapping("save")
    public ResponseEntity<TeamStatistics> save(@Valid @RequestBody TeamStatistics teamStatistics) {
        TeamStatistics newTeamStatistics = TeamStatisticsFactory.createTeamStatistics(teamStatistics.getTeamId(), teamStatistics.getTrophiesWon(), teamStatistics.getMatchesPlayed());
        TeamStatistics teamStatisticsSaved = this.teamStatisticsService.save(newTeamStatistics);
        return ResponseEntity.ok(teamStatisticsSaved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<TeamStatistics> read(@PathVariable String id) {
        TeamStatistics readTeamStatistics= this.teamStatisticsService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
        return ResponseEntity.ok(readTeamStatistics);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(TeamStatistics teamStatistics) {
        this.teamStatisticsService.delete(teamStatistics);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.teamStatisticsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<TeamStatistics>> findAll() {
        List<TeamStatistics> findAllTeamStatisticsList = this.teamStatisticsService.findAll();
        return ResponseEntity.ok(findAllTeamStatisticsList);
    }

}
