CREATE DATABASE IF NOT EXISTS tp_spring_etudiants
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE tp_spring_etudiants;

CREATE TABLE IF NOT EXISTS etudiant (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  matricule VARCHAR(30) NOT NULL UNIQUE,
  nom VARCHAR(80) NOT NULL,
  prenom VARCHAR(80) NOT NULL,
  email VARCHAR(120) NULL UNIQUE,
  date_naissance DATE NULL,
  niveau VARCHAR(20) NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO etudiant(matricule, nom, prenom, email, date_naissance, niveau)
VALUES
('ET-0001', 'NDOUMBE', 'Patrick', 'patrick.ndoumbe@test.com', '2003-05-12', 'L3'),
('ET-0002', 'KAMGA', 'Aline', 'aline.kamga@test.com', '2002-11-03', 'M1');
