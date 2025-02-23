package com.project.apartment.controller;

import com.project.apartment.model.BienImmobilier;
import com.project.apartment.services.BienImmobilierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Biens")
public class BienImmobilierController {
    private final BienImmobilierService bienservice;

    public BienImmobilierController(BienImmobilierService bienservice) {
        this.bienservice = bienservice;
    }
    @PostMapping
    public BienImmobilier createBien(@RequestBody BienImmobilier bien){
       return bienservice.addBienImmobilier(bien);
    }
    @GetMapping
    public List<BienImmobilier> getAllBien(){
        return bienservice.listBienImmobilier();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BienImmobilier> getBienById(@PathVariable Long id){
        Optional<BienImmobilier> bien = bienservice.getBienById(id);
        return bien.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBienById(@PathVariable Long id){
        bienservice.deleteBien(id);
        return ResponseEntity.noContent().build();
    }
}
