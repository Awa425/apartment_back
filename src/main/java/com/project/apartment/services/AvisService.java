package com.project.apartment.services;

import com.project.apartment.model.Avis;
import com.project.apartment.repository.AvisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvisService {
    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }
    public Avis addAvis(Avis avis) {
        return avisRepository.save(avis);
    }
    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }
    public Optional<Avis> getAvisById(Long id) {
        return avisRepository.findById(id);
    }
    public void deleteAvis(Long id) {
        avisRepository.deleteById(id);
    }
}
