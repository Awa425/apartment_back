package com.project.apartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String username;
    private String motDePasse;
    private String role; // Locataire ou Proprietaire

    @OneToMany(mappedBy = "proprietaire")
    private List<Annonce> annoncesPubliees;

    @OneToMany(mappedBy = "expediteur")
    private List<Message> messages;

    @OneToMany(mappedBy = "proprietaire")
    private List<BienImmobilier> biensPossedes;
}
