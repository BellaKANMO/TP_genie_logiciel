import { Component } from '@angular/core';
import { SoapService } from '../../../services/soap.service';

@Component({
  selector: 'app-soap-info',
  templateUrl: './soap-info.component.html'
})
export class SoapInfoComponent {

  compteId!: number;

  resultat: any = null;

  constructor(private soapService: SoapService) {}

  consulterCategorie() {
    this.soapService.getCategorieCompte(this.compteId).subscribe({
      next: res => this.resultat = res,
      error: err => console.error(err)
    });
  }
}
