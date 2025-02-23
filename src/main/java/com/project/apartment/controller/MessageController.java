package com.project.apartment.controller;

import com.project.apartment.model.Message;
import com.project.apartment.model.Utilisateur;
import com.project.apartment.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public Message envoyerMessage(@RequestBody Message message) {
        return messageService.envoyerMessage(message);
    }

    @GetMapping
    public List<Message> getAllMessage() {
        return messageService.obtenirTousLesMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageParId(@PathVariable Long id) {
        Optional<Message> message = messageService.obtenirMessageParId(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/expediteur/{id}")
    public List<Message> getMessagesEnvoyes(@PathVariable Long id) {
        Utilisateur expediteur = new Utilisateur();
        expediteur.setId(id);
        return messageService.getMessagesByUser(expediteur);
    }
}
