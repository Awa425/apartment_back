package com.project.apartment.controller;

import com.project.apartment.model.Annonce;
import com.project.apartment.services.AnnonceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {
    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }
    @PostMapping
    public Annonce createAnnonce(@RequestBody Annonce annonce){
        return annonceService.createAnnonce(annonce);
    }
    @GetMapping
    public List<Annonce> getAllAnnonce(){
        return annonceService.getAllAnnonce();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getOneByAnnonce(@PathVariable Long id){
        Optional<Annonce> annonce = annonceService.getAnnonceById(id);
        return annonce.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }

}
