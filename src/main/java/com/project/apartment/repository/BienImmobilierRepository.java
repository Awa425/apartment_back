package com.project.apartment.repository;

import com.project.apartment.model.BienImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienImmobilierRepository extends JpaRepository<BienImmobilier,Long> {
}
