import { Component } from '@angular/core';
import { CompteService } from '../../../services/compte.service';
import { SoapService } from '../../../services/soap.service';

@Component({
  selector: 'app-compte-list',
  templateUrl: './compte-list.component.html'
})
export class CompteListComponent {

  utilisateurId!: number;

  comptes: any[] = [];

  compteEnEdition: any = null;

  categorie: any = null;

  constructor(private compteService: CompteService, private soapService: SoapService) {}

  rechercher() {
    this.compteService.getByUtilisateur(this.utilisateurId).subscribe(data => {
      this.comptes = data;
    });
  }

  voirCategorie(compte: any) {
    this.soapService.getCategorieCompte(compte.id).subscribe({
      next: res => this.categorie = res,
      error: err => console.error(err)
    });
  }

  modifier(compte: any) {
    this.compteEnEdition = { ...compte };
  }

  annuler() {
    this.compteEnEdition = null;
  }

  enregistrerModification() {
    this.compteService.update(this.compteEnEdition.id, this.compteEnEdition).subscribe({
      next: () => {
        this.compteEnEdition = null;
        this.rechercher();
      },
      error: err => console.error(err)
    });
  }
}
