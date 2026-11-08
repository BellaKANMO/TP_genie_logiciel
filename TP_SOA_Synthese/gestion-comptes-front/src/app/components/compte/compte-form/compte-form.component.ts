import { Component } from '@angular/core';
import { CompteService } from '../../../services/compte.service';

@Component({
  selector: 'app-compte-form',
  templateUrl: './compte-form.component.html'
})
export class CompteFormComponent {

  utilisateurId!: number;

  compte = {
    numeroCompte: '',
    typeCompte: '',
    solde: 0
  };

  constructor(private compteService: CompteService) {}

  enregistrer() {
    this.compteService.add(this.utilisateurId, this.compte).subscribe({
      next: res => {
        alert('Compte ajouté avec succès');
        this.compte = { numeroCompte: '', typeCompte: '', solde: 0 };
      },
      error: err => console.error(err)
    });
  }
}
