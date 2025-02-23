package com.project.apartment.services;

import com.project.apartment.model.VisiteVirtuelle;
import com.project.apartment.repository.VisiteVirtuelleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisiteVirtuelleService {
    private final VisiteVirtuelleRepository visiteVirtuelleRepository;

    public VisiteVirtuelleService(VisiteVirtuelleRepository visiteVirtuelleRepository) {
        this.visiteVirtuelleRepository = visiteVirtuelleRepository;
    }
    public VisiteVirtuelle addVisiteVirtuelle(VisiteVirtuelle visite) {
        return visiteVirtuelleRepository.save(visite);
    }
    public List<VisiteVirtuelle> getAllVisites() {
        return visiteVirtuelleRepository.findAll();
    }
    public Optional<VisiteVirtuelle> getVisiteById(Long id) {
        return visiteVirtuelleRepository.findById(id);
    }
    public void deleteVisiteVirtuelle(Long id) {
        visiteVirtuelleRepository.deleteById(id);
    }
}
