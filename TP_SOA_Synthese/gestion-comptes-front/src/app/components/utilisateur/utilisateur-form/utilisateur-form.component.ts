import { Component } from '@angular/core';
import { UtilisateurService } from '../../../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html'
})
export class UtilisateurFormComponent {

  utilisateur = {
    nom: '',
    email: ''
  };

  constructor(private utilisateurService: UtilisateurService) {}

  enregistrer() {
    this.utilisateurService.add(this.utilisateur).subscribe({
      next: res => {
        alert('Utilisateur ajouté avec succès');
        this.utilisateur = { nom: '', email: '' };
      },
      error: err => console.error(err)
    });
  }
}
