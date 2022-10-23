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
import za.ac.cput.domain.entity.Manager;
import za.ac.cput.factory.entity.ManagerFactory;
import za.ac.cput.service.entity.impl.ManagerServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/soccer-management/manager/")
public class ManagerController
{
    private final ManagerServiceImpl managerService;

    public ManagerController(ManagerServiceImpl managerService) {
        this.managerService = managerService;
    }

    @PostMapping("save")
    public ResponseEntity<Manager> save(@Valid @RequestBody Manager manager) {
        System.out.println("Manager: " + manager);
        Manager createManager =
                ManagerFactory.createManager(manager.getEmpNumber(), manager.getClubName(), manager.getJobTitle(), manager.getYearsExperience(), manager.getPersonalDetails());
        return ResponseEntity.ok(managerService.save(createManager));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Manager> read(@PathVariable String id) {
        Manager manager = this.managerService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager Not Found"));
        return ResponseEntity.ok(manager);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Manager manager) {
        this.managerService.delete(manager);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.managerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Manager>> findAll() {
        List<Manager> allManager = this.managerService.readAll();
        return ResponseEntity.ok(allManager);
    }
}
