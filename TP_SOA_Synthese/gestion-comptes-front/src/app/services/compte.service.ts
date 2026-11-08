import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../models/compte.model';

@Injectable({
  providedIn: 'root'
})
export class CompteService {

  private apiUrl = 'http://localhost:8080/api/comptes';

  constructor(private http: HttpClient) { }

  getByUtilisateur(utilisateurId: number): Observable<Compte[]> {
    return this.http.get<Compte[]>(`${this.apiUrl}/utilisateur/${utilisateurId}`);
  }

  add(utilisateurId: number, compte: Compte): Observable<Compte> {
    return this.http.post<Compte>(`${this.apiUrl}/utilisateur/${utilisateurId}`, compte);
  }

  update(id: number, compte: Compte): Observable<Compte> {
    return this.http.put<Compte>(`${this.apiUrl}/${id}`, compte);
  }
}
