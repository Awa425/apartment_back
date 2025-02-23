package com.project.apartment.services;

import com.project.apartment.model.Utilisateur;
import com.project.apartment.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    public Utilisateur createUser(Utilisateur user){
        return utilisateurRepository.save(user);
    }
    public List<Utilisateur> getAllUsers(){
        return utilisateurRepository.findAll();
    }
    public Optional<Utilisateur> getUserById(Long id){
        return utilisateurRepository.findById(id);
    }
    public Optional<Utilisateur> getUserByUsername(String username){
        return utilisateurRepository.findByUsername(username);
    }
  /*  public Utilisateur updateUser(Long id, Utilisateur user) {
        return utilisateurRepository.findById(id)
                .map(utilisateur -> {
                    utilisateur.setNom(user.getNom());
                    utilisateur.setUsername(user.getUsername());
                    utilisateur.setMotDePasse(user.getMotDePasse());
                    utilisateur.setRole(user.getRole());
                    return utilisateurRepository.save(utilisateur);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }*/
    public void deleteUser(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
