package com.project.apartment.controller;

import com.project.apartment.model.Utilisateur;
import com.project.apartment.services.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    // Ajouter les routes pour les utilisateurs (GET, POST, PUT, DELETE)
    @PostMapping
    public Utilisateur addUser(@RequestBody Utilisateur user){
        return utilisateurService.createUser(user);
    }
    @GetMapping
    public List<Utilisateur> getAllUsers(){
        return utilisateurService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id){
        Optional<Utilisateur> utilisateur = utilisateurService.getUserById(id);
        return utilisateur.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        utilisateurService.deleteUser(id);
        return ResponseEntity.notFound().build();
    }
}
