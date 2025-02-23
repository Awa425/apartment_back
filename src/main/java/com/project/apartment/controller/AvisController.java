package com.project.apartment.controller;

//import com.project.apartment.model.Avis;
import com.project.apartment.model.Avis;
import com.project.apartment.services.AvisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avis")
public class AvisController {
    private final AvisService avisService;

    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }
    @PostMapping
    public Avis createAvis(@RequestBody Avis avis){
        return avisService.addAvis(avis);
    }
    @GetMapping
    public List<Avis> getAllAvis(){
        return avisService.getAllAvis();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable Long id){
        Optional<Avis> avis = avisService.getAvisById(id);
        return avis.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvis(@PathVariable Long id){
        avisService.deleteAvis(id);
        return ResponseEntity.noContent().build();
    }
}
