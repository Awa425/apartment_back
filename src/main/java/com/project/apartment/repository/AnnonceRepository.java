package com.project.apartment.repository;

import com.project.apartment.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
}
