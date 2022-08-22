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
import za.ac.cput.domain.contract.PlayerContract;
import za.ac.cput.service.contract.ManagerContractService;
import za.ac.cput.service.contract.impl.ManagerContractServiceImpl;
import za.ac.cput.domain.contract.ManagerContract;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("soccer-management/managerContract/")
@Slf4j
public class ManagerContractController  {

    private final ManagerContractService managerContractService;

    @Autowired
    public ManagerContractController(ManagerContractServiceImpl managerContractService) {
        this.managerContractService= managerContractService;
    }

    @PostMapping("save")
    public ResponseEntity<ManagerContract> save(@Valid @RequestBody ManagerContract managerContract) {
        log.info("Request to save Manager Contract: {}", managerContract);
        ManagerContract save = managerContractService.save(managerContract);
        return ResponseEntity.ok(save);
    }



    @GetMapping("read/{id}")
    public ResponseEntity<ManagerContract> read(@PathVariable String id) {
        ManagerContract read = managerContractService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager Contract Not found"));
        return ResponseEntity.ok(read);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<ManagerContract>> findAll() {
        List<ManagerContract> findAllList = this.managerContractService.findAll();
        return ResponseEntity.ok(findAllList);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(ManagerContract managerContract) {
        log.info("Request to delete Manager Contract: {}", managerContract);
        this.managerContractService.delete(managerContract);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        Optional<ManagerContract> readManagerContract = this.managerContractService.read(id);

        if(readManagerContract.isPresent()) {

            this.managerContractService.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
}

