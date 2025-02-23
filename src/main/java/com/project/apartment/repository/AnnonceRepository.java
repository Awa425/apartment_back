package com.project.apartment.repository;

import com.project.apartment.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
    Optional<Annonce> findByPrix(Double prix);
}
