package com.project.apartment.repository;

import com.project.apartment.model.Message;
import com.project.apartment.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByExpediteur(Utilisateur expediteur);

    List<Message> findByDestinataire(Utilisateur destinataire);
}
