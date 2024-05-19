package com.example.demome.service;

import com.example.demome.model.Employe;
import com.example.demome.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getEmployes() {
        return this.employeRepository.findAll();
    }

    public Optional<Employe> getEmployeById(Long id) {
        return this.employeRepository.findById(id);
    }

    public void addNewEmploye(Employe employe) {
        this.employeRepository.save(employe);
    }

    public void deleteEmploye(Long employeId) {
        boolean exists = employeRepository.existsById(employeId);
        if (!exists) {
            throw new IllegalStateException("Employe id :" + employeId + " n'existe pas");
        }
        employeRepository.deleteById(employeId);
    }

    @Transactional
    public Employe updateEmploye(Long employeId, String nom, String email) {
        Optional<Employe> optionalEmploye = employeRepository.findById(employeId);
        if (optionalEmploye.isEmpty()) {
            throw new IllegalStateException("Employe id :" + employeId + " n'existe pas");
        }
        Employe employe = optionalEmploye.get();
        if (nom != null) {
            employe.setNom(nom);
        }
        if (email != null) {
            employe.setEmail(email);
        }
        return employeRepository.save(employe);
    }
}
