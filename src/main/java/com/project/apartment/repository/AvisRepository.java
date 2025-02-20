package com.project.apartment.repository;

import com.project.apartment.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis,Long> {
}
