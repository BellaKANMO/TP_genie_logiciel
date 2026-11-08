package com.example.gestioncomptes.controller;

import com.example.gestioncomptes.entity.Utilisateur;
import com.example.gestioncomptes.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping
    public Utilisateur ajouter(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.ajouter(utilisateur);
    }

    @GetMapping
    public List<Utilisateur> lister() {
        return utilisateurService.lister();
    }

    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        utilisateurService.supprimer(id);
    }
}
