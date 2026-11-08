package com.example.gestioncomptes.controller;

import com.example.gestioncomptes.entity.Compte;
import com.example.gestioncomptes.service.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CompteController {

    private final CompteService compteService;

    @PostMapping("/utilisateur/{utilisateurId}")
    public Compte ajouterCompte(@PathVariable Long utilisateurId, @RequestBody Compte compte) {
        return compteService.ajouterCompte(utilisateurId, compte);
    }

    @GetMapping
    public List<Compte> listerTous() {
        return compteService.listerTous();
    }

    @GetMapping("/{id}")
    public Compte getById(@PathVariable Long id) {
        return compteService.getById(id);
    }

    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Compte> listerParUtilisateur(@PathVariable Long utilisateurId) {
        return compteService.listerParUtilisateur(utilisateurId);
    }

    @PutMapping("/{id}")
    public Compte modifier(@PathVariable Long id, @RequestBody Compte compte) {
        return compteService.modifier(id, compte);
    }
}
