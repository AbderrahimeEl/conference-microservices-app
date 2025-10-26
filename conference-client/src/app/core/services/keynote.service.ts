import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Keynote } from '../../shared/models/keynote.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KeynoteService {
    private apiUrl = 'http://localhost:8081/keynotes';
  
    constructor(private http: HttpClient) { }
  
    getKeynote(id: number): Observable<Keynote> {
      return this.http.get<Keynote>(this.apiUrl+"/"+id);
    }

    getAllkeynotes(): Observable<Keynote[]>{
      return this.http.get<Keynote[]>(this.apiUrl)
    }
}
