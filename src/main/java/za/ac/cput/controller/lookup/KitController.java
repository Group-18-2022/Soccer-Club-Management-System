package za.ac.cput.controller.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.lookup.Kit;
import za.ac.cput.factory.lookup.KitFactory;
import za.ac.cput.service.lookup.impl.KitServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/kit/")
public class KitController {
    private final KitServiceImpl kitService;

    @Autowired
    public KitController(KitServiceImpl service) {
        this.kitService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Kit> save(@Valid @RequestBody Kit kit) {
        Kit saveKit = KitFactory.createKit(kit.getKitType(), kit.getKitColor(), kit.getKitBrand());
        return ResponseEntity.ok(kitService.save(saveKit));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Kit> read(@PathVariable String id) {
        var kit = this.kitService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kit Not Found"));
        return  ResponseEntity.ok(kit);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Boolean> delete(Kit kit) {
        this.kitService.delete(kit);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        this.kitService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<Kit>> findAll() {
        List<Kit> kits = this.kitService.findAll();
        return ResponseEntity.ok(kits);
    }
}
