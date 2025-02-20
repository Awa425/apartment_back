package com.project.apartment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private Double prix;
    private String statut;
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "bien_id")
    private BienImmobilier bien;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Utilisateur proprietaire;

    @OneToMany(mappedBy = "annonce")
    private List<Avis> avis;

    @OneToMany(mappedBy = "annonce")
    private List<VisiteVirtuelle> visitesVirtuelles;
}
