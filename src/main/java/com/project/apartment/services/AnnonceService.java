package com.project.apartment.services;

import com.project.apartment.model.Annonce;
import com.project.apartment.repository.AnnonceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce createAnnonce(Annonce annonce){
        return annonceRepository.save(annonce);
    }
    public List<Annonce> getAllAnnonce(){
        return annonceRepository.findAll();
    }
    public Optional<Annonce> getAnnonceById(Long id){
        return annonceRepository.findById(id);
    }
    public Optional<Annonce> getAnnonceByPrix(Double prix){
        return annonceRepository.findByPrix(prix);
    }
    /*public Annonce updateAnnonce(Long id, Annonce detailAnnonce){
        return annonceRepository.findById(id)
                .map(annonce->{
                    annonce.setTitre(detailAnnonce.getTitre());
                    annonce.setDescription(detailAnnonce.getDescription());
                    annonce.setPrix(detailAnnonce.getPrix());
                    annonce.setStatut(detailAnnonce.getStatut());
                    return annonceRepository.save(annonce);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }*/
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}
