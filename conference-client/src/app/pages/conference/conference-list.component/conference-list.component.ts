import { Component, OnInit, signal } from '@angular/core';
import { Conference } from '../../../shared/models/conference.model';
import { ConferenceService } from '../../../core/services/conference.service';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-conference-list.component',
  imports: [RouterLink],
  templateUrl: './conference-list.component.html',
  styleUrl: './conference-list.component.css',
})
export class ConferenceListComponent implements OnInit {

  conferences: Conference[] = [];
  loading = signal(true);

  constructor(private conferenceService: ConferenceService) {}

  ngOnInit(): void {
    this.conferenceService.getConferences().subscribe({
      next: (data) => {
        this.conferences = data;
        this.loading.set(false);
        console.log(data)
      },
      error: (err) => {
        console.error('Error fetching conferences:', err);
        this.loading.set(false);
      }
    });
  }
}