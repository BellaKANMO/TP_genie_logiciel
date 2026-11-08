package com.example.tp_etudiants.service;

import com.example.tp_etudiants.dto.EtudiantRequest;
import com.example.tp_etudiants.dto.EtudiantResponse;
import com.example.tp_etudiants.entity.Etudiant;
import com.example.tp_etudiants.exception.NotFoundException;
import com.example.tp_etudiants.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtudiantService {

    private final EtudiantRepository repo;

    public EtudiantService(EtudiantRepository repo) {
        this.repo = repo;
    }

    public List<EtudiantResponse> list() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public EtudiantResponse get(Long id) {
        Etudiant e = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Etudiant introuvable, id=" + id));
        return toResponse(e);
    }

    @Transactional
    public EtudiantResponse create(EtudiantRequest req) {
        if (repo.existsByMatricule(req.matricule)) {
            throw new IllegalArgumentException("Matricule déjà utilisé");
        }
        if (req.email != null && !req.email.isBlank() && repo.existsByEmail(req.email)) {
            throw new IllegalArgumentException("Email déjà utilisé");
        }
        Etudiant e = new Etudiant();
        apply(e, req);
        return toResponse(repo.save(e));
    }

    @Transactional
    public EtudiantResponse update(Long id, EtudiantRequest req) {
        Etudiant e = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Etudiant introuvable, id=" + id));

        if (!e.getMatricule().equals(req.matricule) && repo.existsByMatricule(req.matricule)) {
            throw new IllegalArgumentException("Matricule déjà utilisé");
        }
        if (req.email != null && !req.email.isBlank()) {
            boolean emailChanged = e.getEmail() == null || !e.getEmail().equals(req.email);
            if (emailChanged && repo.existsByEmail(req.email)) {
                throw new IllegalArgumentException("Email déjà utilisé");
            }
        }
        apply(e, req);
        return toResponse(repo.save(e));
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Etudiant introuvable, id=" + id);
        }
        repo.deleteById(id);
    }

    private void apply(Etudiant e, EtudiantRequest req) {
        e.setMatricule(req.matricule);
        e.setNom(req.nom);
        e.setPrenom(req.prenom);
        e.setEmail(req.email);
        e.setDateNaissance(req.dateNaissance);
        e.setNiveau(req.niveau);
    }

    private EtudiantResponse toResponse(Etudiant e) {
        EtudiantResponse r = new EtudiantResponse();
        r.id = e.getId();
        r.matricule = e.getMatricule();
        r.nom = e.getNom();
        r.prenom = e.getPrenom();
        r.email = e.getEmail();
        r.dateNaissance = e.getDateNaissance();
        r.niveau = e.getNiveau();
        return r;
    }
}
