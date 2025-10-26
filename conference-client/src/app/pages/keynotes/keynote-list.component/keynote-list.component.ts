import { Component, OnInit, signal, Signal } from '@angular/core';
import { Keynote } from '../../../shared/models/keynote.model';
import { KeynoteService } from '../../../core/services/keynote.service';

@Component({
  selector: 'app-keynote-list.component',
  imports: [],
  templateUrl: './keynote-list.component.html',
  styleUrl: './keynote-list.component.css',
})
export class KeynoteListComponent implements OnInit{

  keynotes?: Keynote[]
  loading = signal(true);

  ngOnInit(): void {
    this.getKeynotes();
  }

  constructor(private keynoteService: KeynoteService){}

  getKeynotes(){
    this.keynoteService.getAllkeynotes().subscribe({
      next: data => {
        this.keynotes = data;
        this.loading.set(false);
        console.log(data);
      },
      error: err => {
        console.error("error fetching keynotes")
        this.loading.set(false)
      }
    })
  }
}
