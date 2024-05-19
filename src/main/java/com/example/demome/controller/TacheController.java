package com.example.demome.controller;

import com.example.demome.model.Tache;
import com.example.demome.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    private final TacheService tacheService;

    @Autowired
    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @GetMapping
    public List<Tache> getAllTaches() {
        return tacheService.getAllTaches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTacheById(@PathVariable Long id) {
        Tache tache = tacheService.getTacheById(id);
        return ResponseEntity.ok(tache);
    }

    @PostMapping
    public Tache createTache(@RequestBody Tache tache) {
        return tacheService.createTache(tache);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tache> updateTache(@PathVariable Long id, @RequestBody Tache tacheDetails) {
        Tache updatedTache = tacheService.updateTache(id, tacheDetails);
        return ResponseEntity.ok(updatedTache);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable Long id) {
        tacheService.deleteTache(id);
        return ResponseEntity.noContent().build();
    }
}