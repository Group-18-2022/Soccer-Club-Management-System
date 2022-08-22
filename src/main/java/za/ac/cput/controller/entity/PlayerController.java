/*
Student Name: Trevor Ngcobo
Student Number: 220477019
Subject: Applications Development Practice 3
Assessment: Capstone Project
Group: 18

 */


package za.ac.cput.controller.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.domain.match.Location;
import za.ac.cput.factory.entity.PlayerFactory;
import za.ac.cput.factory.match.LocationFactory;
import za.ac.cput.service.entity.impl.PlayerServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/soccer-management/player/")
public class PlayerController
{
    private final PlayerServiceImpl playerService;

    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @PostMapping("save")
    public ResponseEntity<Player> save(@Valid @RequestBody Player player) {
        Player createPLayer =
                PlayerFactory.createPlayer(player.getEmpNumber(), player.getFieldPosition(), player.getJerseyNumber(), player.getTeamId(), player.getPersonalDetails());
        return ResponseEntity.ok(playerService.save(createPLayer));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Player> read(@PathVariable String id) {
        Player player = this.playerService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player Not Found"));
        return ResponseEntity.ok(player);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Player pLayer) {
        this.playerService.delete(pLayer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.playerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Player>> findAll() {
        List<Player> allPlayer = this.playerService.readAll();
        return ResponseEntity.ok(allPlayer);
    }
}
