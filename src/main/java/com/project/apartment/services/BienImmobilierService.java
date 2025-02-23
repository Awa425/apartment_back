package com.project.apartment.services;

import com.project.apartment.model.BienImmobilier;
import com.project.apartment.repository.BienImmobilierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BienImmobilierService {
    private final BienImmobilierRepository bienImmobilierRepository;;

    public BienImmobilierService(BienImmobilierRepository bienImmobilierRepository) {
        this.bienImmobilierRepository = bienImmobilierRepository;
    }

    public BienImmobilier addBienImmobilier(BienImmobilier bien){
        return bienImmobilierRepository.save(bien);
    }
    public List<BienImmobilier> listBienImmobilier(){
        return bienImmobilierRepository.findAll();
    }
    public Optional<BienImmobilier> getBienById(Long id){
        return bienImmobilierRepository.findById(id);
    }
   /* public BienImmobilier updateBien(Long id, BienImmobilier bienDetails) {
        return bienImmobilierRepository.findById(id)
                .map(bien -> {
                    bien.setType(bienDetails.getType());
                    bien.setAdresse(bienDetails.getAdresse());
                    bien.setSuperficie(bienDetails.getSuperficie());
                    bien.setNombrePieces(bienDetails.getNombrePieces());
                    bien.setMeuble(bienDetails.getMeuble());
                    bien.setDescription(bienDetails.getDescription());
                    return bienImmobilierRepository.save(bien);
                })
                .orElseThrow(() -> new RuntimeException("Bien immobilier non trouvé"));
    }*/
    public void deleteBien(Long id) {
        bienImmobilierRepository.deleteById(id);
    }
}
