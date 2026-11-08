import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SoapCategorie } from '../models/soap-categorie.model';

@Injectable({
  providedIn: 'root'
})
export class SoapService {

  private apiUrl = 'http://localhost:8080/api/soap';

  constructor(private http: HttpClient) { }

  getCategorieCompte(compteId: number): Observable<SoapCategorie> {
    return this.http.get<SoapCategorie>(`${this.apiUrl}/compte/${compteId}/categorie`);
  }
}
