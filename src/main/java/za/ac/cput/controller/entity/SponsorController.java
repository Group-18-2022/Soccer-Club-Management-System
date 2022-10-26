package za.ac.cput.controller.entity;

/* SponsorController.java
   Controller for the Sponsor
   Author: Joshua Daniel Jonkers(215162668)
   Date: 19/08/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Sponsor;
import za.ac.cput.factory.SponsorFactory;
import za.ac.cput.service.entity.impl.SponsorServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/sponsor/")
public class SponsorController {
    private final SponsorServiceImpl sponsorService;

    @Autowired
    public SponsorController(SponsorServiceImpl service) { this.sponsorService = service; }

    @PostMapping("save")
    public ResponseEntity<Sponsor> save(@Valid @RequestBody Sponsor sponsor) {
        Sponsor newSponsor = SponsorFactory.createSponsor(sponsor.getRoleId(), sponsor.getTaxNumber(), sponsor.getCompanyName());
        return ResponseEntity.ok(sponsorService.save(newSponsor));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Sponsor> read(@PathVariable String id) {
        Sponsor readSponsor = this.sponsorService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sponsor not found"));
        return ResponseEntity.ok(readSponsor);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Sponsor sponsor) {
        this.sponsorService.delete(sponsor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.sponsorService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Sponsor>> findAll() {
        List<Sponsor> sponsorList = this.sponsorService.findAll();
        return ResponseEntity.ok(sponsorList);
    }
}
