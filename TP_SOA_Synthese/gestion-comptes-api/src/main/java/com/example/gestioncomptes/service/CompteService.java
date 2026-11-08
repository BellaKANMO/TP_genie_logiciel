package com.example.gestioncomptes.service;

import com.example.gestioncomptes.entity.Compte;
import com.example.gestioncomptes.entity.Utilisateur;
import com.example.gestioncomptes.repository.CompteRepository;
import com.example.gestioncomptes.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompteService {

    private final CompteRepository compteRepository;
    private final UtilisateurRepository utilisateurRepository;

    public Compte ajouterCompte(Long utilisateurId, Compte compte) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        compte.setUtilisateur(utilisateur);
        return compteRepository.save(compte);
    }

    public List<Compte> listerTous() {
        return compteRepository.findAll();
    }

    public List<Compte> listerParUtilisateur(Long utilisateurId) {
        return compteRepository.findByUtilisateurId(utilisateurId);
    }

    public Compte getById(Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    public Compte modifier(Long id, Compte donnees) {
        Compte compte = getById(id);
        compte.setNumeroCompte(donnees.getNumeroCompte());
        compte.setTypeCompte(donnees.getTypeCompte());
        compte.setSolde(donnees.getSolde());
        return compteRepository.save(compte);
    }
}
