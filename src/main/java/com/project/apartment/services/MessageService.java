package com.project.apartment.services;

import com.project.apartment.model.Message;
import com.project.apartment.model.Utilisateur;
import com.project.apartment.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public Message envoyerMessage(Message message) {
        return messageRepository.save(message);
    }
    public List<Message> obtenirTousLesMessages() {
        return messageRepository.findAll();
    }
    public Optional<Message> obtenirMessageParId(Long id) {
        return messageRepository.findById(id);
    }
    // Récupérer les messages envoyés par un utilisateur
    public List<Message> getMessagesByUser(Utilisateur expediteur) {
        return messageRepository.findByExpediteur(expediteur);
    }
    // Récupérer les messages reçus par un utilisateur
    public List<Message> getMessageRecuByUser(Utilisateur destinataire) {
        return messageRepository.findByDestinataire(destinataire);
    }
}
