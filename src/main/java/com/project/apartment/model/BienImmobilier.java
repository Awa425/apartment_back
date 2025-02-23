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
public class BienImmobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String type;
    private String adresse;
    private Integer superficie;
    private Integer nombrePieces;
    private Boolean meuble;
    private Integer etage;
    private Integer mensualite;
    private Integer caution;
    private Date date;
    private Integer dureDeBail;
    private String description;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Utilisateur proprietaire;

    @OneToMany(mappedBy = "bien")
    private List<Annonce> annonces;
}
