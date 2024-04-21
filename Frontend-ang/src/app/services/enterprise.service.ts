import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Enterprise} from "../models/enterprise";

@Injectable({
  providedIn: 'root'
})
export class EnterpriseService {
  private apiUrl = 'http://localhost:8089/IO/Enterprise';

  constructor(private http: HttpClient) { }

  getEnterprises(): Observable<Enterprise[]> {
    return this.http.get<Enterprise[]>(this.apiUrl);
  }

  addEnterprise(enterprise: Enterprise): Observable<Enterprise> {
    return this.http.post<Enterprise>(this.apiUrl, enterprise);
  }

  updateEnterprise(enterprise: Enterprise): Observable<Enterprise> {
    return this.http.put<Enterprise>(`${this.apiUrl}/${enterprise.id}`, enterprise);
  }

  deleteEnterprise(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
