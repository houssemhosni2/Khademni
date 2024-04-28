import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Competence} from "../models/competence";

@Injectable({
  providedIn: 'root'
})
export class CompetenceService {
  private apiUrl = 'http://localhost:8089/IO/competence/all';

  constructor(private http: HttpClient) {
    this.apiUrl='http://localhost:8089/IO/competence/all';
  }

  getCompetences(): Observable<Competence[]> {
    return this.http.get<Competence[]>(this.apiUrl);
  }

  addCompetence(competence: Competence){
    return this.http.post<Competence>(this.apiUrl, competence);
  }
}
