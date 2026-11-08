package com.example.tp_etudiants.dto;

import java.time.LocalDate;

public class EtudiantResponse {
    public Long id;
    public String matricule;
    public String nom;
    public String prenom;
    public String email;
    public LocalDate dateNaissance;
    public String niveau;
}
