package za.ac.cput.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.entity.Manager;
import za.ac.cput.domain.entity.Player;
import za.ac.cput.service.entity.impl.ManagerServiceImpl;
import za.ac.cput.service.entity.impl.PlayerServiceImpl;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/user/")
public class AuthController {

    private final ManagerServiceImpl managerService;
    private final PlayerServiceImpl playerService;

    @Autowired
    public AuthController(ManagerServiceImpl managerService, PlayerServiceImpl playerService) {
        this.managerService = managerService;
        this.playerService = playerService;
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDTO loginDTO) {
        var isManager = managerService.findManagerByByNameAndEmail(loginDTO.getName(), loginDTO.getEmail());
        if(isManager.isPresent())
            return ResponseEntity.ok((Manager) isManager.get());

        var isPlayer = playerService.findPlayerByByNameAndEmail(loginDTO.getName(), loginDTO.getEmail());
        if(isPlayer.isPresent())
            return ResponseEntity.ok((Player) isPlayer.get());

        return ResponseEntity.badRequest().body("Invalid Details");
    }
}
