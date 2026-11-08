import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from '../../../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-list',
  templateUrl: './utilisateur-list.component.html'
})
export class UtilisateurListComponent implements OnInit {

  utilisateurs: any[] = [];

  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    this.chargerUtilisateurs();
  }

  chargerUtilisateurs() {
    this.utilisateurService.getAll().subscribe(data => {
      this.utilisateurs = data;
    });
  }

  supprimer(id: number) {
    if (!confirm('Supprimer cet utilisateur et ses comptes ?')) {
      return;
    }
    this.utilisateurService.delete(id).subscribe(() => this.chargerUtilisateurs());
  }
}
