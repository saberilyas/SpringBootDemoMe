package com.example.demome.controller;

import com.example.demome.model.Employe;
import com.example.demome.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/emp"})
public class EmployeCtrl {
    private final EmployeService employeService;

    @Autowired
    public EmployeCtrl(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getEmployes() {
        return this.employeService.getEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employe>> getEmployeById(@PathVariable Long id) {
        Optional<Employe> employe = employeService.getEmployeById(id);
        return ResponseEntity.ok(employe);
    }

    @PostMapping
    public void registerNewEmploye(@RequestBody Employe employe) {
        this.employeService.addNewEmploye(employe);
    }

    @DeleteMapping(path = "{employeId}")
    public String deleteEmploye(@PathVariable ("employeId") Long employeId ){
        employeService.deleteEmploye(employeId);
        return ("employe ID "+employeId + " deleted with succes---");

    }

    @PutMapping(path = "{employeId}")
    public Employe updateEmploye(
            @PathVariable ("employeId") Long employeId,
            @RequestParam (required = false) String nom,
            @RequestParam (required = false) String email
            ){
        return employeService.updateEmploye(employeId,nom,email);
    }

}
