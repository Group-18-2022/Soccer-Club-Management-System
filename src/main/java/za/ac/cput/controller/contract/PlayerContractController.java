package za.ac.cput.controller.contract;

/*
 Mponeng Ratego
 216178991
*/


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.service.contract.PlayerContractService;
import za.ac.cput.service.contract.impl.PlayerContractServiceImpl;
import za.ac.cput.domain.contract.PlayerContract;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("soccer-management/playerContract/")
@Slf4j
public class PlayerContractController  {

    private final PlayerContractService playerContractService;

    @Autowired
    public PlayerContractController(PlayerContractServiceImpl playerContractService) {
        this.playerContractService= playerContractService;
    }

    @PostMapping("save")
    public ResponseEntity<PlayerContract> save(@Valid @RequestBody PlayerContract playerContract) {
        log.info("Request to save Player Contract: {}", playerContract);
        PlayerContract save = playerContractService.save(playerContract);
        return ResponseEntity.ok(save);
    }



    @GetMapping("read/{id}")
    public ResponseEntity<PlayerContract> read(@PathVariable String id) {
        PlayerContract read = playerContractService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Player Contract Not found"));
        return ResponseEntity.ok(read);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<PlayerContract>> findAll() {
        List<PlayerContract> findAllList = this.playerContractService.findAll();
        return ResponseEntity.ok(findAllList);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(PlayerContract playerContract) {
        log.info("Request to delete Player Contract: {}", playerContract);
        this.playerContractService.delete(playerContract);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        Optional<PlayerContract> readPlayerContract = this.playerContractService.read(id);

        if(readPlayerContract.isPresent()) {

            this.playerContractService.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
}
