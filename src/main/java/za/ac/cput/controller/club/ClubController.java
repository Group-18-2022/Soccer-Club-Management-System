package za.ac.cput.controller.club;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.club.Club;
import za.ac.cput.factory.club.ClubFactory;
import za.ac.cput.service.club.impl.ClubServiceImpl;

import javax.validation.Valid;
import java.util.List;
/**
 * This is the Club Controller
 * @author Charles Moses Lemmert (220498385)
 * **/
@RestController
@RequestMapping("api/v1/soccer-management/club/")
public class ClubController {

    private final ClubServiceImpl clubService;

    @Autowired
    public ClubController(ClubServiceImpl clubService){
        this.clubService =clubService;
    }
    @PostMapping("save")
    public ResponseEntity<Club> save(@Valid @RequestBody Club club){
       Club saveClub = ClubFactory.createClub(club.getClubID(),club.getClubName()
               ,club.getClubOwner(),club.getIsRegisteredClub());
       return ResponseEntity.ok(clubService.save(saveClub));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Club> read(@PathVariable String id){
        Club readClub = this.clubService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Club not found"));
        return ResponseEntity.ok(readClub);

    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Club club) {
        this.clubService.delete(club);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        this.clubService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Club>> findAll(){
        List<Club> findClubs = this.clubService.findAllClubs();
        return ResponseEntity.ok(findClubs);
    }

}
