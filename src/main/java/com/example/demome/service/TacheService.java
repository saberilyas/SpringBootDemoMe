package com.example.demome.service;

import com.example.demome.model.Tache;
import com.example.demome.repository.TacheRepository;
import com.example.demome.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    public Tache getTacheById(Long id) {
        return tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée avec id :" + id));
    }

    public Tache createTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public Tache updateTache(Long id, Tache tacheDetails) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée avec id :" + id));

        tache.setName(tacheDetails.getName());
        tache.setDescription(tacheDetails.getDescription());
        tache.setDateStart(tacheDetails.getDateStart());
        tache.setDateEnd(tacheDetails.getDateEnd());
        tache.setStatut(tacheDetails.getStatut());

        return tacheRepository.save(tache);
    }

    public void deleteTache(Long id) {
        Tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tâche non trouvée avec id :" + id));

        tacheRepository.delete(tache);
    }
}
