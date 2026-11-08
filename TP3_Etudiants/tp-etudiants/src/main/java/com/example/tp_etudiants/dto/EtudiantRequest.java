package com.example.tp_etudiants.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class EtudiantRequest {

    @NotBlank @Size(max = 30)
    public String matricule;

    @NotBlank @Size(max = 80)
    public String nom;

    @NotBlank @Size(max = 80)
    public String prenom;

    @Email @Size(max = 120)
    public String email;

    public LocalDate dateNaissance;

    @Size(max = 20)
    public String niveau;
}
