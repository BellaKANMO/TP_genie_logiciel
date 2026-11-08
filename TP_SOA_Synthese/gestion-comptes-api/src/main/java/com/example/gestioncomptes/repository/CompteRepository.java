package com.example.gestioncomptes.repository;

import com.example.gestioncomptes.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    List<Compte> findByUtilisateurId(Long utilisateurId);
}
