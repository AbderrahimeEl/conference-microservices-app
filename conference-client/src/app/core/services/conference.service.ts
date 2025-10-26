// src/app/core/services/conference.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Conference } from '../../shared/models/conference.model';

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {

  private apiUrl = 'http://localhost:8082/conferences'; // your API endpoint

  constructor(private http: HttpClient) { }

  getConferences(): Observable<Conference[]> {
    return this.http.get<Conference[]>(this.apiUrl);
  }
}
